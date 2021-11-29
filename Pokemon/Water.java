/*
@Vritik Mistry
*/

/**
 * Interface Water is implemented by Squirtle and Staryu Class and specifies that the pokemons are of grass type.
 * It gives special funcionalities and abilities to pokemons Squirtle and Staryu through the special attacks
 * methods. 
 * @author Vritik Mistry
 */
public class Water extends Pokemon{

  public Water(String n, int h, int m) {
    super(n, h, m);
  }

  @Override
  public String getAttackMenu(int atkType) {
    String atkMenu = "";
    if(atkType == 2) {
      atkMenu = "1. Water Gun \n2. Bubble Beam \n3. Waterfall";
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
        atk = " uses WATER GUN on ";
      }
      else if(move == 2) {
        atk = " uses BUBBLE BEAM on ";
      }
      else if (move == 3) {
        atk = " uses WATERFALL on ";
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
    else {
      super.getAttackMultiplier(p, atkType);
    }
    return multiplier;
  }
}
