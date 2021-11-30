/*
@Khoa Luu
*/

/**
 * @author Khoa Luu
 */
public class Grass extends Pokemon{

  public Grass(String n, int h, int m) {
    super(n, h, m);
  }

  @Override
  public String getAttackMenu(int atkType) {
    String atkMenu = "";
    if(atkType == 2) {
      atkMenu = "1. Vine Whip \n2. Razor Leaf \n3. Solar Beam";
    }
    else {
      return super.getAttackMenu(atkType);
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
    else {
      return super.getAttackString(atkType, move);
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
    else {
      return super.getAttackDamage(atkType, move);
    }
    return dmg;
  }

  @Override
  public double getAttackMultiplier(Pokemon p, int atkType) {
    double multiplier = 0;
    if(atkType == 2) {
      multiplier = battleTable[this.getType()][p.getType()];
    }
    else {
      return super.getAttackMultiplier(p, atkType);
    }
    return multiplier;
  }
}