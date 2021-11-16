/*
@Khoa Luu
*/

/**
 * Interface Grass is implemented by Bulbasaur and Oddish Class and specifies that the pokemons are of grass type.
 * It gives special funcionalities and abilities to pokemons Bulbasaur and Oddish through the special attacks
 * methods. 
 * @author Khoa Luu
 */
public interface Grass {
  String specialMenu = "1 Vine Whip \n2. Razor Leaf \n3. Solar Beam";
  int numSpecialMenuItems = 3;

  /**
   * Method to generate battle description and to calculate damage when Vine Whip is choosen for special attack.
   */
  String vineWhip(Pokemon p);
  /**
   * Method to generate battle description and to calculate damage when Razor Leaf is choosen for special attack.
   */
  String razorLeaf(Pokemon p);
  /**
   * Method to generate battle description and to calculate damage when Solar Beam is choosen for special attack.
   */
  String solarBeam(Pokemon p);

}