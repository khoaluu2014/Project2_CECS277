/*
@Joshua Peng
*/
import java.awt.Point;
import java.util.ArrayList;

/**
 * Class Trainer is a type of Entity and inherits variables and methods from Entity class. Trainer is 
 * given an initial amount of money, potions, and pokeballs. Trainer gets the map, the location on 
 * the map and the initial pokemon which is added to the pokemon list. Trainer moves depending on the 
 * choice of direction, the move is checked for validity and the location of trainer is updated.
 * @author Joshua Peng
 */
public class Trainer extends Entity{
  
  int money;
  int potions;
  int pokeballs;
  Point loc;
  Map map;
  ArrayList<Pokemon> pokemon;

  /**
   * Creates a Trainer object with name n, object Pokemon p and object Map m as parameters.
   * @param n name of the Trainer.
   * @param p pokemon that gets added to pokemon list .
   * @param m map that shows location of trainer and his encounters.
   */
  public Trainer(String n, Pokemon p, Map m){
    /**
     * Calls superclass Entity's constructor with matching parameters.
	   * @param n name of trainer.
	   * @param 25 initial hp value for the trainer.
	   */
    super(n,25);
    map = m;
    money = 10;
    potions = 2;
    pokeballs = 3;
    pokemon = new ArrayList<Pokemon>();
    pokemon.add(p);
    loc =  m.findStart();
  }

  /**
   * Trainer is given certain amount of money in the beginning.
   * @return returns the trainer's amount of money.
   */
  public int getMoney(){
	  return money;
  }

  /**
   * Compares the trainer's money with the price of the potion or pokeball. 
   * If trainer has enough money, subtracts the price of the item.
   * @param amt  price of potion or poke ball
   * @return  true or false.
   */
  public boolean spendMoney(int amt){  
	  if (money >= amt){
		  money = money - amt;
		  return true;		  
	  }
	  else {		 
		  return false;
	  }
  }	
  
  /**
  * Updates the money amount by adding money when trainer lands on 'i' in map. 
  * @param amt  amount of money trainer gets if randomly selected to earn money.
  */
  public void receiveMoney(int amt){
	  money = money + amt;  
  }
  
  /**
   * Checks to make sure the trainer has potions when choosing to use potions in battle.
   * If user has potions, it will allow the trainer to use it, else a message is printed
   * @return  true or false.
   */
  public boolean hasPotion(){
	  if (potions >= 1) {
		  return true;
	  }
	  else {
		  return false;
	  }	  
  }

  /**
   * Updates the potion amount by adding the number of potions when trainer buys potion from the store. 
   */
  public void receivePotion(){
	  potions = potions + 1;
  }

  /**
   * The trainer here then uses potions.
   * @param pokeindex index of the pokemon the trainer's using on.
   */
  public void usePotion(int pokeindex){
      if(getPokemon(pokeindex).getHp() > 0)
      {
          getPokemon(pokeindex).heal();
          potions--;
      }
      else
      {
          System.out.println("You can't revive downed Pokemons.");
      }
  }

  /**
   * Checks if trainer has enough pokeballs to use in battles.
   * @return  true or false.
   */
  public boolean hasPokeball(){
	  if (pokeballs > 0) {
		  return true;
	  }
	  else {
		  return false;
	  }
  }

  /**
   * Updates the pokeball amount by adding 1 pokeball to trainer's pokeball count when trainer buys pokeballs
   * from the store. 
   */
  public void receivePokeball(){
	  pokeballs = pokeballs + 1;
  }

  /**
   * Checks if trainer has pokeballs to catch pokemons and calculate the percent chance of catching the pokemon. 
   * Pokemon is caught and added to pokemon list if catch percentage is equal or less than difference of MaxHp and Hp.
   * @return  true or false
   */
  public boolean catchPokemon(Pokemon p){
	  if (hasPokeball()) {
      int catchPercentage = Rand.randIntRange(0, p.getMaxHp());
      pokeballs -= 1;
      if(catchPercentage <= p.getMaxHp() - p.getHp())
      {
        pokemon.add(p);
        return true;
      }
      else
      {
        return false;
      }
      		  
	  }
    else {
      return false;
    }
  }
  
  /**
   * Gets the location of the trainer on the map.
   * @return the point location of trainer.
   */
  public Point getLocation(){
	  return loc;
  }
  
  /**
   * Moves trainer one row up or translate x by -1.
   * @return  the character at trainer's location after the translation.
   */
  // north - cannot go x < 0
  public char goNorth() {
      loc.translate(-1, 0);
      if(map.getCharAtLoc(loc) == 'x')
      {
          loc.translate(1, 0);
          return 'x';
      }
    return map.getCharAtLoc(loc);
  }
  
  /**
   * Moves trainer one row down or translate x by +1.
   * @return  the character at trainer's location after the translation.
   */
    public char goSouth() {
      loc.translate(1, 0);
      if(map.getCharAtLoc(loc) == 'x')
      {
          loc.translate(-1, 0);
          return 'x';
      }
	return map.getCharAtLoc(loc);
  }
  
  /**
   * Moves trainer one column to the right or translate y by +1.
   * @return  the character at trainer's location after the translation.
   */
  public char goEast(){
      loc.translate(0, 1);
      if(map.getCharAtLoc(loc) == 'x')
      {
          loc.translate(0, -1);
          return 'x';
      }
    return map.getCharAtLoc(loc);
  }
  
  /**
   * Moves trainer one column to the left or translate y by -1.
   * @return  the character at trainer's location after the translation.
   */
  public char goWest(){
      loc.translate(0, -1);
      if(map.getCharAtLoc(loc) == 'x')
      {
          loc.translate(0, 1);
          return 'x';
      }
	  return map.getCharAtLoc(loc); 
	  }	  

  /**
   * Gets the number of the pokemon to keep track of its hp. 
   * @return  the number of the pokemon.
   */
  public int getNumPokemon(){
	  int numPokemon = 0;
    for(int i = 0; i < pokemon.size(); i++)
    {
      numPokemon++;
    }
    return numPokemon;
  }
  
  /**
   * Heals the pokemon that the trainer chooses during the battle.
   */
  public void healAllPokemon(){
	  for(int i = 0; i < pokemon.size(); i++)
    {
      pokemon.get(i).heal();
    }
  }
 
  /**
   * Gets the index of the pokemon from the list of pokemons. Trainer selects pokemon from the list 
   * to battle or to heal.
   * @param index index of the pokemon that the trainer selects. 
   * @return index from the list of pokemons.
   */
  public Pokemon getPokemon(int index){
    return pokemon.get(index);
  }

  /**
   * Gets the list of pokemons to battle or heal. Trainer selects from the list.
   * @return list of pokemons
   */
  public String getPokemonList(){
    String pokemonList = "";
    pokemonList += ("Pokemon: \n---------------\n");
	  for(int i = 0; i < pokemon.size(); i++)
    {
      pokemonList += (i+1) + ". " + pokemon.get(i) + "\n";
    }
    return pokemonList;
  }

  /**
   * String representation of the Trainer Object. 
   * @return string summary of trainer's health, supplies and pokemons. 
   */
  @Override
  public String toString(){
	  String str =  super.toString() + "\nMoney: " + money + "\nPotions: " + potions + "\nPoke Balls: " + pokeballs + "\n" + getPokemonList();
    return str;
  }
}


