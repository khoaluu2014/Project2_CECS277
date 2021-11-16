/*
@Khoa Luu
*/

/**
 * Class Bulbasaur is a type of Pokemon and inherits variables and methods from 
 * Pokemon class. Class Bulbasaur also implements Grass interface and calls 
 * the variables and methods for the special attacks which are based on its grass type.
 * @author Khoa Luu
 */
public class Bulbasaur extends Pokemon implements Grass {
  public Bulbasaur()
  {
    /**
	   * Calls superclass Pokemon's constructor and assigns "Bulbasaur" for name of pokemon.
		 * @param "Bulbasaur" name of trainer's pokemon or wild pokemon.
		 */
    super(" Bulbasaur");
  }

  /**
   * Gets special menu for the grass special attacks by returning the specialMenu variable
   * created in Grass interface.
   * return@ string menu of special attacks for grass type.
   */
  public String getSpecialMenu()
  {
    return specialMenu;
  }

  /**
   * Gets the number of items in the menu by returning the numSpecialMenuItems variable created
   * in Grass interface. Used in Main class to set the upper range for special attacks menu choices. 
   * return@ number of items in the special attack menu.
   */
  public int getNumSpecialMenuItems()
  {
    return numSpecialMenuItems;
  }

  /**
   * Gets the special attack description for the trainer's pokemon or the wild pokemon based on the 
   * trainer's menu choice for special attack move or based on the wild pokemon's random menu choice.
   * @param pokemon selected by trainer or wild pokemon that trainer encounters.
   * @return string summary of battle description based on move type by calling special attack method.
   */
  public String specialAttack(Pokemon p, int move)
  {
    String specialAttack = "";
    if(move == 1)
    {
      specialAttack = vineWhip(p);
    }
    else if(move == 2)
    {
      specialAttack = razorLeaf(p);
    }
    else if(move == 3)
    {
      specialAttack = solarBeam(p);
    }
    return specialAttack;
  }

  /**
   * Gives the battle description when trainer chooses Vine Whip or when wild pokemon randomly 
   * chooses Vine Whip for special attack, and calculates the amount of damage that wild pokemon takes,
   * as well as the damage taken on the trainer's pokemon.
   * @param p wild pokemon that trainer's pokemon is fighting with.
   * @return string summary of battle description.
   */
  public String vineWhip(Pokemon p)
  {
    String vineWhip = "";
    double damage = Rand.randIntRange(1, 3) * this.damageMultiplier(p);
    vineWhip = this.getName() + " uses VINE WHIP on " + p.getName();
    p.takeDamage((int)damage);
    return vineWhip;
  }

  /**
   * Gives the battle description when trainer chooses Razor Leaf or when wild pokemon randomly 
   * chooses Razor Leaf for special attack, and calculates the amount of damage that wild pokemon takes,
   * as well as the damage taken on the trainer's pokemon.
   * @param p wild pokemon that trainer's pokemon is fighting with.
   * @return string summary of battle description.
   */
  public String razorLeaf(Pokemon p)
  {
    String razorLeaf = "";
    double damage = Rand.randIntRange(2, 4) * this.damageMultiplier(p);
    razorLeaf = this.getName() + " uses RAZOR LEAF on " + p.getName();
    p.takeDamage((int)damage);
    return razorLeaf;
  }

  /**
   * Gives the battle description when trainer chooses Solar Beam or when wild pokemon randomly 
   * chooses Solar Beam for special attack, and calculates the amount of damage that wild pokemon takes,
   * as well as the damage taken on the trainer's pokemon.
   * @param p wild pokemon that trainer's pokemon is fighting with.
   * @return string summary of battle description.
   */
  public String solarBeam(Pokemon p)
  {
    String solarBeam = "";
    double damage = Rand.randIntRange(0, 5) * this.damageMultiplier(p);
    solarBeam = this.getName() + " uses SOLAR BEAM on " + p.getName();
    p.takeDamage((int)damage);
    return solarBeam;
  }
}