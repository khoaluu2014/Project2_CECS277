/*
@Khoa Luu
*/

import java.util.Random;

/**
 * Class Rand creates a new instance of object Random and generates a random value with minimum 
 * and maximum range to be used in different areas of the game where random values are needed.
 * @author Khoa Luu
 */
public class Rand {

  /**
   * Generates a random number with a minimum and maximum range.
   * @param min, an int for the lower bound of the range for random, inclusive
   * @param max, an int for the upper bound of the range for random, inclusive
   * @return a pseudo random number within the range.
   */
  public static int randIntRange(int min, int max)
  {
    Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
  }
}