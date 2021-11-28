/*
@Vritik Mistry
*/

/**
 * Class Squirtle is a type of Pokemon and inherits variables and methods from 
 * Pokemon class. Class Squirtle also implements Water interface and calls 
 * the variables and methods for the special attacks which are based on its water type.
 * @author Vritik Mistry
 */
public class Squirtle extends Pokemon implements Water{
  public Squirtle(){
    /**
	   * Calls superclass Pokemon's constructor and assigns "Squirtle" for name of pokemon.
		 * @param "Squirtle" name of trainer's pokemon or wild pokemon.
		 */
    super("Squirtle");
  }

  /**
   * Gets special menu for the water special attacks by returning the specialMenu variable
   * created in Water interface.
   * return@ string menu of special attacks for water type.
   */
  @Override
  public String getSpecialMenu()
  {
    return specialMenu;
  }

  /**
   * Gets the number of items in the menu by returning the numSpecialMenuItems variable created
   * in Water interface. Used in Main class to set the upper range for special attacks menu choices. 
   * return@ number of items in the special attack menu.
   */
  public int getNumSpecialMenuItems(){
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
    if(move == 1){
      specialAttack = waterGun(p);
    }
    else if(move == 2){
      specialAttack = bubbleBeam(p);
    }
    else if(move == 3){
      specialAttack = waterFall(p);
    }
    return specialAttack;
  }

  /**
   * Gives the battle description when trainer chooses Water Gun or when wild pokemon randomly 
   * chooses Water Gun for special attack, and calculates the amount of damage that wild pokemon takes,
   * as well as the damage taken on the trainer's pokemon.
   * @param p wild pokemon that trainer's pokemon is fighting with.
   * @return string summary of battle description.
   */
  public String waterGun(Pokemon p){
    String waterGun = "";
    double damage = Rand.randIntRange(2,5) * this.damageMultiplier(p);
    waterGun = this.getName() + "uses WATER GUN on " + p.getName();
    p.takeDamage((int)damage);
    return waterGun;
  }

  /**
   * Gives the battle description when trainer chooses Water Gun or when wild pokemon randomly 
   * chooses Water Gun for special attack, and calculates the amount of damage that wild pokemon takes,
   * as well as the damage taken on the trainer's pokemon.
   * @param p wild pokemon that trainer's pokemon is fighting with.
   * @return string summary of battle description.
   */
  public String bubbleBeam(Pokemon p){
    String bubbleBeam = "";
    double damage = Rand.randIntRange(1,3) * this.damageMultiplier(p);
    bubbleBeam = this.getName() + "uses BUBBLE BEAM on " + p.getName();
    p.takeDamage((int)damage);
    return bubbleBeam;
  }

  /**
   * Gives the battle description when trainer chooses Waterfall or when wild pokemon randomly 
   * chooses Waterfall for special attack, and calculates the amount of damage that wild pokemon takes,
   * as well as the damage taken on the trainer's pokemon.
   * @param p wild pokemon that trainer's pokemon is fighting with.
   * @return string summary of battle description.
   */
  public String waterFall(Pokemon p){
    String waterFall = "";
    double damage = Rand.randIntRange(1,4) * this.damageMultiplier(p);
    waterFall = this.getName() + "uses WATER FALL on " + p.getName();
    p.takeDamage((int)damage);
    return waterFall;
  }
}
 

