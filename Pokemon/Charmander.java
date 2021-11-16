/*
@Joshua Peng
*/

/**
 * Class Charmander is a type of Pokemon and inherits variables and methods from 
 * Pokemon class. Class Charmander also implements Fire interface and calls 
 * the variables and methods for the special attacks which are based on its fire type.
 * @author Joshua Peng
 */
public class Charmander extends Pokemon implements Fire{
	public Charmander() {
    /**
	   * Calls superclass Pokemon's constructor and assigns "Charmander" for name of pokemon.
		 * @param "Charmander" name of trainer's pokemon or wild pokemon.
		 */
		super("Charmander");  		  
  }

  /**
   * Gets special menu for the fire special attacks by returning the specialMenu variable
   * created in Fire interface.
   * return@ string menu of special attacks for fire type.
   */
  public String getSpecialMenu() {
	  return specialMenu;
  }

  /**
   * Gets the number of items in the menu by returning the numSpecialMenuItems variable created
   * in Fire interface. Used in Main class to set the upper range for special attacks menu choices. 
   * return@ number of items in the special attack menu.
   */
  public int getNumSpecialMenuItems() {
	  return  numSpecialMenuItems;
  }
  
  /**
   * Gives the battle description when trainer chooses Ember or when wild pokemon randomly 
   * chooses Ember for special attack, and calculates the amount of damage that wild pokemon takes,
   * as well as the damage taken on the trainer's pokemon.
   * @param p wild pokemon that trainer's pokemon is fighting with.
   * @return string summary of battle description.
   */
  public String ember(Pokemon p) {
	  String ember = this.getName() + " uses EMBER on " + p.getName();
	  double damage = Rand.randIntRange(0,3) * this.damageMultiplier(p);
	  p.takeDamage((int)damage);
	  return ember;  
  }

  /**
   * Gives the battle description when trainer chooses Fire Blast or when wild pokemon randomly 
   * chooses Fire Blast for special attack, and calculates the amount of damage that wild pokemon takes,
   * as well as the damage taken on the trainer's pokemon.
   * @param p wild pokemon that trainer's pokemon is fighting with.
   * @return string summary of battle description.
   */
  public String fireBlast(Pokemon p) {
	  String fireBlast = this.getName() + " uses FIRE BLAST on " + p.getName();
	  double damage = Rand.randIntRange(1,4) * this.damageMultiplier(p);
	  p.takeDamage((int)damage);
	  return fireBlast;
  }

  /**
   * Gives the battle description when trainer chooses Fire Punch or when wild pokemon randomly 
   * chooses Fire Punch for special attack, and calculates the amount of damage that wild pokemon takes,
   * as well as the damage taken on the trainer's pokemon.
   * @param p wild pokemon that trainer's pokemon is fighting with.
   * @return string summary of battle description.
   */
  public String firePunch(Pokemon p) {
	  String firePunch = this.getName() + " uses FIRE PUNCH on " + p.getName();
	  double damage = Rand.randIntRange(1,3) * this.damageMultiplier(p);
	  p.takeDamage((int)damage);
	  return firePunch; 
  }

  /**
   * Gets the special attack description for the trainer's pokemon or the wild pokemon based on the 
   * trainer's menu choice for special attack move or based on the wild pokemon's random menu choice.
   * @param pokemon selected by trainer or wild pokemon that trainer encounters.
   * @return string summary of battle description based on move type by calling special attack method.
   */
  public String specialAttack(Pokemon p, int move) {
	  if (move == 1) {
			 return ember(p);
		 }	 
		 else if (move == 2) {	
			 return fireBlast(p);
		 }
		 else if (move == 3) {
			 return firePunch(p); 
		 }
		 return "a";
	  } 
}
