/*
@Vritik Mistry
*/

/**
 * Interface Water is implemented by Squirtle and Staryu Class and specifies that the pokemons are of grass type.
 * It gives special funcionalities and abilities to pokemons Squirtle and Staryu through the special attacks
 * methods. 
 * @author Vritik Mistry
 */
interface Water{

  String specialMenu = "1.Water Gun\n2. Bubble Beam\n3. Waterfall";
  int numSpecialMenuItems = 3;

  /**
   * Method to generate battle description and to calculate damage when Water Gun is choosen for special attack.
   */
  String waterGun(Pokemon p);
  /**
   * Method to generate battle description and to calculate damage when Bubble Beam is choosen for special attack.
   */
  String bubbleBeam(Pokemon p);
  /**
   * Method to generate battle description and to calculate damage when Waterfall is choosen for special attack.
   */
  String waterFall(Pokemon p);
  
  



}