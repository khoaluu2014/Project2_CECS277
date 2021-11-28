/*
@Khoa Luu
*/

/**
 * Interface Grass is implemented by Bulbasaur and Oddish Class and specifies that the pokemons are of grass type.
 * It gives special funcionalities and abilities to pokemons Bulbasaur and Oddish through the special attacks
 * methods. 
 * @author Khoa Luu
 */
public class Grass extends Pokemon{
<<<<<<< Updated upstream
=======

  public Grass(String n, int h, int m) {
    super(n, h, m);
  }

  @Override
  public String getAttackMenu(int atkType) {
    if(atkType == 2) {
      System.out.print()
    }
  }
>>>>>>> Stashed changes


  public Grass(String n, int h, int m) {
    super(n, h, m);
  }

  @Override
  public String getAttackMenu(int atkType) {
    String atkMenu = "";
    if(atkType == 2) {
      atkMenu = "1 Vine Whip \n2. Razor Leaf \n3. Solar Beam";
    }
    return atkMenu;
  }

  @Override
  public int getNumAttackMenuItems(int atkType) {
    return 3;
  }

  @Override
  public String getAttackString(int atkType, int move) {
    String atk = "";
    if(atkType == 2) {
      if(move == 1) {
        atk = " uses VINE WHIP on ";
      }
      else if(move == 2) {
        atk = " uses RAZOR LEAF on ";
      }
      else if (move == 3) {
        atk = " uses SOLAR BEAM on ";
      }
    }
    return atk;
  }

  @Override
  public int getAttackDamage(int atkType, int move) {
    int dmg = 0;
    if(atkType == 2) {
      if(move == 1) {
        dmg = Rand.randIntRange(1, 3);
      }
      else if(move == 2) {
        dmg = Rand.randIntRange(2, 4);
      }
      else if(move == 3) {
        dmg = Rand.randIntRange(0, 5);
      }
    }
    return dmg;
  }

  @Override
  public double getAttackMultiplier(Pokemon p, int atkType) {
    double multiplier = 0;
    if(atkType == 2) {
      multiplier = battleTable[this.getType()][p.getType()];
    }
    return multiplier;
  }
}