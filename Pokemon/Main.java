import java.util.ArrayList;

/**
 * The Pokemon program is a game where the goal is to catch as many pokemons as possible. The player, who is the new trainer
 * of pokemons, travels to different areas and encounter different situations with options to fight and catch pokemons, 
 * increase supplies, heal pokemons or to take on damages.  
 * @author Khoa Luu, Vritik Mistry, Joshua Peng.
 */

class Main {
  /**
   * Runs the program by first prompting user to enter name and select among 3 pokemons to start.
   * Creates new instances of a Map and a Trainer object. User or trainer explores the different
   * areas by moving along the map and having different encounters where there are choices to fight, heal, or buy 
   * potions or pokeballs. Pokemons can take on damages if trainer chooses to fight or there are also random
   * encounters where random damages can occur on trainer.
   */
  public static void main(String[] args) { 
    char encounter = '\0'; 
    int menuChoice = 0;
    int mapNumber = 1;
    int level = 0;
    System.out.print("Prof. Oak: Hello there new trainer, what is your name?\n");
    String name = CheckInput.getString();
    // Display menu and ask player to choose pokemon.
    System.out.println("Great to meet you, " + name + "!\n"
                       + "Choose your first pokemon:\n"
                       + "1. Charmander\n" + "2. Bulbasaur\n" + "3. Squirtle");
    // Validate player input.
    int pokemonChoice = CheckInput.getIntRange(1,3);
    Map m = Map.getInstance();
    Pokemon poke;
    if(pokemonChoice == 1)
    {
      poke = PokemonGenerator.getInstance().getPokemon("Charmander");
    }
    else if(pokemonChoice == 2)
    {
      poke = PokemonGenerator.getInstance().getPokemon("Bulbasaur");
    }
    else
    {
      poke = PokemonGenerator.getInstance().getPokemon("Squirtle");
    }
    // Load map and trainer.
    m.loadMap(1);
    Trainer trainer = new Trainer(name, poke);
    // Load main menu.
    while (menuChoice != 5 && trainer.getHp() > 0) {
      int hpSum = 0;
      for(int i = 0; i < trainer.getNumPokemon(); i++)
      {
        hpSum += trainer.getPokemon(i).getHp();
      }
      System.out.println(trainer);
      menuChoice = mainMenu();
      if (menuChoice == 1){
        m.reveal(trainer.getLocation());
        encounter = trainer.goNorth();
      }
      else if(menuChoice == 2){
        m.reveal(trainer.getLocation());
        encounter = trainer.goSouth();
      }  
      else if(menuChoice == 3) {
        m.reveal(trainer.getLocation());
        encounter = trainer.goEast();
      }
      else if(menuChoice == 4) {
        m.reveal(trainer.getLocation());
        encounter = trainer.goWest();
      } 
      else if(menuChoice == 5) {
      System.out.println("You've exited the game.");
      }  
      if (menuChoice != 5){    
      // Trainer has different encounters depending on his/her position on the map.
      // When Trainer reaches finish (f), it is blocked by Gym Leader who needs to be defeated for trainer to move up to next map.
      if (encounter == 'f') {
        // Trainer to defeat Gym Leader by fighting with leader's pokemon.
        System.out.print("You have to defeat my pokemon! You don't have an option of throwing a pokeball or runningg away.");

        Pokemon wildPokemon = PokemonGenerator.getInstance().generateRandomPokemon(level);
        // Random Gym Leader's pokemon appears.
        System.out.println("Gym Leader's " + wildPokemon.getName() + " has appeared.");
        int menuChoiceW;
        while(wildPokemon.getHp() != 0 && hpSum > 0) {
          System.out.println("What do you want to do? \n"
                  + "1. Fight\n" + "2. Use Potion\n");
          hpSum = 0;
          for(int i = 0; i < trainer.getNumPokemon(); i++)
          {
            hpSum += trainer.getPokemon(i).getHp();
          }
          menuChoiceW = CheckInput.getIntRange(1, 2);
          if(hpSum > 0) {
            if (menuChoiceW == 1) {
              // Fight.
              trainerAttack(trainer, wildPokemon);
            } else if (menuChoiceW == 2) {
              // Use Potion.
              if (trainer.hasPokeball()) {
                System.out.println("Which pokemon do you want to heal?\n" + trainer.getPokemonList());
                int potionChoice = CheckInput.getIntRange(1, trainer.getNumPokemon());
                if (trainer.getPokemon(potionChoice - 1).getHp() > 0) {
                  trainer.usePotion(potionChoice - 1);
                } else {
                  System.out.println("You can't revive downed Pokemons.");
                }
              } else {
                System.out.println("You don't have any potions.");
              }
            }
          }
          else {
            System.out.println("All your pokemon are downed. You take damage for them. Try again next time.");
              trainer.takeDamage(5);
          }
        }
        level +=1;
        mapNumber++;
        if(mapNumber > 3)
        {
          mapNumber = 1;
        }
        if(wildPokemon.getHp() == 0) {
          m.loadMap(mapNumber);
        }
      }
      else if (encounter == 'n') { // No encounter found.
        System.out.println("There is nothing here!");
      }
      else if (encounter == 'i') { // Finds item.
        int itemNumber = Rand.randIntRange(1,3);
        if (itemNumber == 1) {
          trainer.receivePokeball();
          System.out.println("You received a Pokeball");
        }
        else if (itemNumber == 2) {
          trainer.receivePotion();
          System.out.println("You received a potion");
        }
        else if (itemNumber == 3) {
          trainer.receiveMoney(2);
          System.out.println("You received 2 Poke money");
        }
        m.removeCharAtLoc(trainer.getLocation());
      }
      // Encounter with wild pokemon - begins a fight.
      else if (encounter == 'w') {
        // Wild pokemon is generated and decorated with random buffs according to pokemon's level.
        Pokemon wildPokemon = PokemonGenerator.getInstance().generateRandomPokemon(level);
        // Random wild pokemon appears.
        System.out.println("A wild " + wildPokemon.getName() + " has appeared.");
        int menuChoiceW = 0;
        boolean isCaught = false;
        int debuff = Rand.randIntRange(1, 10);
        if(debuff <= 4) {
          wildPokemon = PokemonGenerator.getInstance().addRandomDebuff(wildPokemon);
          System.out.println("Your Pokemons has scared the wild Pokemon.");
        }
        else if(debuff == 5) {
          trainer.debuffAllPokemon();
          System.out.println("The wild Pokemon has intimidated your Pokemons.");
        }
        while(menuChoiceW != 4 && wildPokemon.getHp() > 0 && hpSum > 0 && !isCaught) {
        System.out.println("What do you want to do? \n"
                  + "1. Fight\n" + "2. Use Potion\n" + "3. Throw Poke Ball\n" 
                  + "4. Run Away");
        hpSum = 0;
        for(int i = 0; i < trainer.getNumPokemon(); i++)
        {
           hpSum += trainer.getPokemon(i).getHp();
        }
        menuChoiceW = CheckInput.getIntRange(1,4);
        if(hpSum > 0)
        {
          if (menuChoiceW == 1) {
            // Fight.
            trainerAttack(trainer, wildPokemon);
          }
          else if (menuChoiceW == 2) {
            // Use Potion.
            if(trainer.hasPotion())
            {
              System.out.println("Which pokemon do you want to heal?\n" + trainer.getPokemonList());
              int potionChoice = CheckInput.getIntRange(1, trainer.getNumPokemon());
              if (trainer.getPokemon(potionChoice - 1).getHp() > 0)
              {
                trainer.usePotion(potionChoice - 1);
              }
              else
              {
                System.out.println("You can't revive downed Pokemons.");
              }
            }
            else
            {
              System.out.println("You don't have any potions.");
            }
          }
          else if (menuChoiceW == 3) {
            // Throw Poke Ball. Catches pokemon based on catching percentage.
            if(trainer.hasPokeball())
            {
              if(trainer.catchPokemon(wildPokemon)) {
                System.out.println("Shake...Shake...Shake...");
                System.out.println("You've successfully caught " + wildPokemon.getName());
                isCaught = true;
              }
              else {
                System.out.println("Shake...Shake...");
                System.out.println(wildPokemon.getName() + " broke free.");
              }
            }
            else {
              System.out.println("You don't have any pokeballs.");
            }
          }
        }
        else {
          System.out.println("All your pokemons are downed. You take damage instead.");
           trainer.takeDamage(3);
        }
        }
        // Run away. Trainer leaves the fight but 'w' is not removed from map.
        if(wildPokemon.getHp() == 0)
        {
          m.removeCharAtLoc(trainer.getLocation());
        }
        else if(hpSum == 0){
          System.out.println("All your pokemons are downed. You take damage instead.");
          trainer.takeDamage(3);
        }
      }  
      else if (encounter == 'p') {  
        // Random person encounter. Causes random damage on the trainer.
        int randomEncounter = Rand.randIntRange(1, 4);
        int d = Rand.randIntRange(1, 3);
        if(randomEncounter == 1)
        {
          System.out.println("Your Pokemons are not happy with your gym badges numbers. They planned a revolution and damaged you in the process.");
          trainer.takeDamage(d);
        }
        else if(randomEncounter == 2)
        {
          System.out.println("Misty wants her bike back. You got slapped.");
          trainer.takeDamage(d);
        }
        else if(randomEncounter == 3)
        {
          System.out.println("Team Rocket wanted revenge, so they setup a trap. Unfortunately, you discovered that the hard way.");
          trainer.takeDamage(d);
        }
        else
        {
          System.out.println("You got pulled over by officer Jenny for riding the Bike when it's not the right time.");
          trainer.takeDamage(d);
        }
      }
        
      else if (encounter == 'c') {
        // Trainer enters city. Choose to go to store or go to hospital to getpokemons healed.
        System.out.println("You've enter the city. Where would you like to go.");
        System.out.println("1. Store \n2. Pokemon Hospital");
        int trainerChoice = CheckInput.getIntRange(1, 2);
        if(trainerChoice == 1)
        {
          store(trainer);
        }
        else if(trainerChoice == 2)
        {
          System.out.println("I'll fix your poor pokemon up in a jiffy! \nThere you go! See you again soon.");
          trainer.healAllPokemon();
        }
      }
    } // Close while loop for main menu.
    if(trainer.getHp() < 0) {
      System.out.println("YOU DIED!");
    }
    }
  }
  
  /**
   * Prints out main menu for the direction choices for map. Calls CheckInput Class to check that
   * menu choice is within the 1-5 range, inclusive.
   * @return menu choice for which direction trainer wants to go.
   */
  public static int mainMenu()
  {
    System.out.println("Main Menu:\n" 
                      + "1. Go North\n" + "2. Go South\n" + "3. Go East\n" 
                      + "4. Go West\n" + "5. Quit");
    return CheckInput.getIntRange(1,5);
  }

  /**
   * Keeps track of the health points for the trainer and the wild pokemons, and prints messages
   * when health points are zero. If trainer has enough health points, then loads the basic menu
   * for attacks. Each attack, basic or special, has a menu for the types of attacks that trainer 
   * can choose from. basicAttack() or specialAttack() methods are called and the descriptions of
   * the attacks are printed out.
   * @param t, trainer who encounters the wild pokemon.
   * @param wild, wild pokemon that appears when trainer encouter 'w' in map.
   */
  public static Pokemon trainerAttack(Trainer t, Pokemon wild)
  {
    String action = "";

      System.out.println(wild);
      System.out.println("Choose a Pokemon \n" + t.getPokemonList());
      int pokemonChoice = CheckInput.getIntRange(1, t.getNumPokemon());
      Pokemon battlePokemon = t.getPokemon(pokemonChoice-1);
      while(battlePokemon.getHp() == 0)
      {
        System.out.println("It's downed. Please choose another one.");
        pokemonChoice = CheckInput.getIntRange(1, t.getNumPokemon());
        battlePokemon = t.getPokemon(pokemonChoice-1);
      }
      System.out.println(battlePokemon.getName() + ", I choose you!");
      System.out.println(battlePokemon.getAttackTypeMenu());
      int choice = CheckInput.getIntRange(1, battlePokemon.getNumAttackTypeMenuItems());

      System.out.println(battlePokemon.getAttackMenu(choice));
      int move = CheckInput.getIntRange(1, battlePokemon.getNumAttackMenuItems(choice));
      action += battlePokemon.attack(wild, choice, move) + "\n";
      //Wild Pokemon Turn
      if(wild.getHp() > 0)
      {
        int wildChoice = Rand.randIntRange(1, 2);
        int wildMove = Rand.randIntRange(1, 3);
        action += wild.attack(battlePokemon, wildChoice, wildMove);
      }


    System.out.println(action);
    System.out.println(wild);
    return battlePokemon;
  }

  /**
   * Prints out the menu for the store. Adds potion or pokeball to trainer's supply,
   * updates trainer's money, or gives trainer option to exit store. Also lets trainer
   * know when money supply is empty. 
   * param t trainer who enters the store to by potion or
   */
  public static void store(Trainer t)
  {
    int menuChoiceStore = 0;
    while(menuChoiceStore != 3)
    {
      System.out.println("Hello! What can I help you with?" + "\n" + "1. Buy Potions - $5" + "\n" + "2. Buy Poke Balls - $3" + "\n" + "3. Exit");
      menuChoiceStore = CheckInput.getIntRange(1,3);
      if(menuChoiceStore == 1)
      {
        // Checks for money, adds 1 potion to trainer's potion supply and subtract $5 for each potion from trainer's money.
        if(t.spendMoney(5))
        {
          t.receivePotion();
          System.out.println("Here's your potion!");
        }
        else
        {
          System.out.println("You have no money");
        }
      }
      else if(menuChoiceStore == 2)
      {
        // Checks for money, adds 1 pokeball to trainer's pokeball supply and subtract $3 for each pokeball from trainer's money.
        if(t.spendMoney(3))
        {
          t.receivePokeball();
          System.out.println("Here's your pokeball!");
        }
        else
        {
          System.out.println("You have no money");
        }
      }
    }
    System.out.println("Please come again.");
  }         
}