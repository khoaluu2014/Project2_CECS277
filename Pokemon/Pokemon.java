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
   * Creates a Pokemon object and passes in the name of the pokemon as a parameter. 
   * @param n name of the pokemon.
   */ 
  public Pokemon(String n)
  {
    /**
    * Calls superclass Entity's constructor with matching parameters.
	  * @param n name of pokemon.
	  * @param 20 initial hp value for the pokemon.
	  */
    super(n, 20);  
  }

  /**
   * Abstract method to get menu for special attacks.
   */
  public abstract String getSpecialMenu();

  /**
   * Abstract method to get the number for the special attack that trainer chooses.
   */ 
  public abstract int getNumSpecialMenuItems();

  /**
   * Abstract method to determine special attack move description that trainer chooses.
   * @param p the pokemon that is chosen by trainer or the wild pokemon that appeared.
   * @param move number that indicates the type of special attack selected.
   */
  public abstract String specialAttack(Pokemon p, int move);

  /**
   * Get the basic menu which is the choice of basic attack or special attack.
   * @return basic menu.
   */
  public String getBasicMenu()
  {
    String basicMenu = "";
    
    basicMenu = "1. Basic Attack \n2. Special Attack.\n";

    return basicMenu;
  }

  /**
   * Gets the number of trainer's choice for either basic attack or special attack.
   * @return the number of choices of attack.
   */
  public int getNumBasicMenuItems()
  {
    return 2;
  }

  /**
   * Gets the basic attack choice from trainer.
   * @return type of basic attack
   */
  public String basicAttack(Pokemon p, int move)
  {
    String basicAttack = "";
    
    if(move == 1)
    {
      basicAttack = slam(p);
    }
    else if(move == 2)
    {
      basicAttack = tackle(p);
    }
    else if(move == 3)
    {
      basicAttack = tackle(p);
    }
    
    return basicAttack;
  }

  /**
   * Prints out basic attack menu.
   * @return basic attack menu.
   */
  public String getAttackMenu()
  {
    String attackMenu = "";
    
    attackMenu = "1. Slam \n2. Tackle \n3. Punch";

    return attackMenu;
  }

  /**
   * Gets the number of trainer's choice of either basic attack or special attack.
   * @return the number of choices of attack.
   */
  public int getNumAttackMenuItems()
  {
    return 3;
  }

  /**
   * Generates the damage from the battle between the trainer's pokemon and the wild pokemon and 
   * gives the battle description.
   * @return the battle description for slam. 
   */
  public String slam(Pokemon p)
  {
    String slam = "";
    slam = this.getName() + " uses slam on " + p.getName();
    int damage = Rand.randIntRange(0, 5);
    p.takeDamage(damage);
    return slam;
  } 

  /**
   * Generates the damage from the battle between the trainer's pokemon and the wild pokemon and 
   * gives the battle description.
   * @return the battle description for tackle
   */
  public String tackle(Pokemon p)
  {
    String tackle = "";
    tackle = this.getName() + " uses tackle on " + p.getName();
    int damage = Rand.randIntRange(2, 3);
    p.takeDamage(damage);
    return tackle;
  } 

  /**
   * Generates the damage from the battle between the trainer's pokemon and the wild pokemon and 
   * gives the battle description.
   * @return the battle description for punch. 
   */
  public String punch(Pokemon p)
  {
    String punch = "";
    punch = this.getName() + " uses punch on " + p.getName();
    int damage = Rand.randIntRange(1, 4);
    p.takeDamage(damage);
    return punch;
  }

  /**
   * Gets the elemental type of pokemon which is either fire, water, or grass.
   * @return the type of pokemon.
   */
  public int getType()
  {
    int type = -1;
    if(this instanceof Ponyta || this instanceof Charmander)
    {
      type = 0;
    }
    else if(this instanceof Squirtle || this instanceof Staryu)
    {
      type = 1;
    }
    else if(this instanceof Oddish || this instanceof Bulbasaur)
    {
      type = 2;
    }
    return type;
  }

   /**
   * Gets the multiplier of the damage depending on the pokemon's type. It uses the battleTable
   * index to identify the multiplier of damage.
   * @return the damage multiplier.
   */ 
  public double damageMultiplier(Pokemon p)
  {
    double damageMultiplier = 0;
    if(this.getType() == 0)
    {
      if(p.getType() == 0)
      {
        damageMultiplier = battleTable[0][0];
      }
      else if(p.getType() == 1)
      {
        damageMultiplier = battleTable[0][1];
      }
      else if(p.getType() == 2)
      {
        damageMultiplier = battleTable[0][2];
      }
    }
    else if(this.getType() == 1)
    {
      if(p.getType() == 0)
      {
        damageMultiplier = battleTable[1][0];
      }
      else if(p.getType() == 1)
      {
        damageMultiplier = battleTable[1][1];
      }
      else if(p.getType() == 2)
      {
        damageMultiplier = battleTable[1][2];
      }
    }
    else if(this.getType() == 2)
    {
      if(p.getType() == 0)
      {
        damageMultiplier = battleTable[2][0];
      }
      else if(p.getType() == 1)
      {
        damageMultiplier = battleTable[2][1];
      }
      else if(p.getType() == 2)
      {
        damageMultiplier = battleTable[2][2];
      }
    }

    return damageMultiplier;
  }
}