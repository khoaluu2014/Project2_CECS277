/*
@Khoa Luu
*/

/**
 * Abstract class Pokemon is a representation of a generic type of pokemon. Pokemon class is extended by a 
 * number of classes that are of pokemon type. Pokemon class is also a type of Entity and inherits 
 * variables and methods from Entity class. Pokemons do different basic attacks and special attacks 
 * based on their types and receive damages accordingly. A battle table is used to assign the multiplier 
 * for the special attacks damages.
 * @author Khoa Luu
 */
public abstract class Pokemon extends Entity{

    static final double [][] battleTable = {{1,.5,2}, {2,1,.5},{.5,2,1}};

    /**
     * Calls superclass Entity's constructor with matching parameters.
     * @param n, name of pokemon.
     * @param h, hp of pokemon.
     * @param m, maxHp of pokemon.
     * Create a Pokemon object with passed in properties.
     */
    public Pokemon(String n, int h, int m) {
      super(n, h, m);
    }

    /**
     *
     * @return String menu for atkType menu
     */
    public String getAttackTypeMenu() {
        return "1. Normal Attack \n2. Special Attack";
    }

    /**
     * Gets the number of trainer's choice for either basic attack or special attack.
     * @return the number of choices of attack.
     */
    public int getNumAttackTypeMenuItems()
    {
      return 2;
    }

    /**
     * Prints out basic attack menu.
     * @param atkType, trainer chooses between basic attack (1) or special attack (2).
     * @return basic attack menu.
     */
    public String getAttackMenu(int atkType)
    {
        return "1. Slam \n2. Tackle \n3. Punch";
    }

    /**
     * Gets the number of trainer's choice of either basic attack or special attack.
     * @param atkType, trainer chooses between basic attack (1) or special attack (2).
     * @return the number of choices of attack.
     */
    public int getNumAttackMenuItems(int atkType)
    {
      return 3;
    }

    /**
     * Calculates total damage for defending and attacking pokemon  & builds the full attack string.
     * @param p, pokemon
     * @param atkType, trainer chooses between basic attack (1) or special attack (2).
     * @param move, type of attack move trainer selects
     * @return string summary of the attack and damage.
     */
    public String attack(Pokemon p, int atkType, int move) {
        int totalDmg = (int) (getAttackDamage(atkType, move) * getAttackMultiplier(p, atkType) + getAttackBonus(atkType));
        p.takeDamage(totalDmg);
        return this.getName() + " " + this.getAttackString(atkType, move) + p.getName() + " for " + totalDmg;
    }

    /**
     * Returns the partial string for the chosen move, which is overriden in the base pokemon classes for special
     * element attacks
     * @param atkType, trainer chooses between basic attack or special attack.
     * @param move, the move that trainer chooses.
     * @return String for the chosen attack move.
     */
    public String getAttackString(int atkType, int move) {
        String atk = " ";

        if(move == 1) {
            atk = "uses Slam on ";
        }
        else if(move == 2) {
            atk = "uses Tackle on ";
        }
        else if(move == 3) {
            atk = "uses Punch on ";
        }
        return atk;
    }

    /**
     * Returns the randomized damage for the chosen move, which is overriden in the base pokemon classes for special
     * element attacks
     * @param atkType, trainer chooses between basic attack or special attack.
     * @param move, the move that trainer chooses.
     * @return random damage based on the chosen move.
     */
    public int getAttackDamage(int atkType, int move) {
      //slam
      if(move == 1) {
        return Rand.randIntRange(0, 5);
      }
      //tackle
      else if(move == 2) {
        return Rand.randIntRange(2, 3);
      }
      //punch
      else if(move == 3) {
        return Rand.randIntRange(1, 4);
      }
      return 0;
    }

    /**
     * Returns the attack multiplier which is 1 if basic attack move is chosen or this method will be overridden in
     * the base pokemon classes for special elemental attacks and will return the result of the
     * battle table (when special attack move is chosen).
     * @param p, pokemon
     * @param atkType, trainer chooses between basic attack (1) or special attack (2).
     * @return 1
     */
    public double getAttackMultiplier(Pokemon p, int atkType)
    {
      return 1;
    }

    /**
     * Returns the attack bonus that will be added to the calculated damage. This method is overriden in the base
     * pokemon classes for the special elemental attacks and in the decoration buff/debuff classes.
     * @param atkType, trainer chooses between basic attack (1) or special attack (2).
     * @return 0
     */
    public int getAttackBonus(int atkType)
    {
        return 0;
    }

    /**
     * Gets the elemental type of pokemon which is either fire, water, or grass.
     * @return the type of pokemon.
     */
    public int getType()
    {
      int type = -1;
      if(this instanceof Fire)
      {
        type = 0;
      }
      else if(this instanceof Water)
      {
        type = 1;
      }
      else if(this instanceof Grass)
      {
        type = 2;
      }
      return type;
    }
  }

