/*
@Joshua Peng
*/

/**
 * Interface Fire is implemented by Charmander and Ponyta Class and specifies that pokemon are of fire type.
 * It gives special funcionalities and abilities to pokemons Charmander and Ponyta through the special attacks
 * methods. 
 * @author Joshua Peng
 */
public interface Fire {
	String specialMenu = "1. Ember\n2. Fire Blast\n3. Fire Punch";
	int numSpecialMenuItems = 3;

  /**
   * Method to generate battle description and to calculate damage when Ember is choosen for special attack.
   */
	String ember(Pokemon p);
  /**
   * Method to generate battle description and to calculate damage when Fire Blast is choosen for special attack.
   */
	String fireBlast(Pokemon p);
  /**
   * Method to generate battle description and to calculate damage when Fire Punch is choosen for special attack.
   */
	String firePunch(Pokemon p);
}
	  
