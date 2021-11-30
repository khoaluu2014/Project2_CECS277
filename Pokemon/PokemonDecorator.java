/*
@Joshua Peng
*/

/**
 * Abstract PokemonDecorator class extends Pokemon class and has base Pokemon types of Fire, Water, Grass,
 * which will be decorated with different types of buffs and debuffs to change pokemon's damage and hp's.
 * @author Joshua Peng
 */

public abstract class PokemonDecorator extends Pokemon{
    private final Pokemon pokemon;

    /**
     * Has instance of the base pokemon type. Calls in superclass Entity's constructor. Also passes in the extra
     * parameters such as extra name and extra HP points.
     * @param p, pokemon that will be decorated.
     * @param extraName, string '+ATK' or '-ATK' added when pokemon's damage is changed during buff or debuff.
     * @param extraHp, string '+HP' or '-HP' added when pokemon's damage is changed during buff or debuff.
     */
    public PokemonDecorator(Pokemon p, String extraName, int extraHp)
    {
        super(p.getName() + extraName, p.getHp() + extraHp, p.getMaxHp() + extraHp);
        pokemon = p;
    }

    /**
     * Gets the menu for the basic attacks by returning the string with the menu choices.
     * return@ string menu for basic attacks..
     */
    public String getAttackMenu(int atkType)
    {
        return "1. Slam \n2. Tackle \n3. Punch";
    }

    /**
     * Gets the number of trainer's choices for the basic attacks menu
     * @return the number of choices for basic attacks menu.
     */
    public int getNumAttackMenuItems(int atkType)
    {
       return 3;
    }
    /**
     * Get the string for the basic attacks that trainer chooses.
     * @param atkType, trainer chooses between basic attack (1) or special attack (2).
     * @param move the move that trainer chooses.
     * @return the string description of the basic attacks that trainer chooses.
     */
    public String getAttackString(int atkType, int move)
    {
    String atkStr= " ";

      if(atkType == 1 && move == 1) {
        atkStr = "uses Slam on ";
        }
      else if(atkType == 1 && move == 2) {
        atkStr = "uses Tackle on ";
        }
      else if(atkType == 1 && move == 3) {
        atkStr = "uses Punch on ";
        }
      return atkStr;
    }

    /**
     * Gets a random damage from a range which is based on the type of basic attack move.
     * @param atkType, trainer chooses between basic attack (1)  or special attack (2).
     * @param move, the move that trainer chooses.
     * @return the damage amount for the basic attack move.
     */
    public int getAttackDamage(int atkType, int move)
    {
      if(move == 1) {
          return Rand.randIntRange(0, 5);
      }

      else if(move == 2) {
          return Rand.randIntRange(2, 3);
      }

      else if(move == 3) {
          return Rand.randIntRange(1, 4);
      }
      return 0;
}

    /**
     * Gets the damage multiplier from Pokemon's class battleTable array for each combination of attack.
     * @param p, wild pokemon that the trainer is fighting with.
     * @param atkType, trainer chooses between basic attack (1) or special attack (2).
     * @return damage multiplier or else returns 1 for basic attack which deals no multiplier.
     */
    public double getAttackMultiplier(Pokemon p, int atkType) {
        double damageMultiplier;
        if (atkType == 2) {
            damageMultiplier = battleTable[this.getType()][p.getType()];
            return damageMultiplier;
        }
        return 1 ;
    }

    /**
     * Gets the attack bonus depending on the type of attack, basic or special.
     * @param atkType, integer for the typy of attack, basic = 1 or special = 2.
     * @return attackBonus to be added to the calculated damage.
     */
    @Override
    public int getAttackBonus(int atkType){
        int attackBonus = 0;
        if(atkType == 1) {
            attackBonus = 1;
        }
        else if(atkType == 2){
            attackBonus = 2;
        }
        return pokemon.getAttackBonus(atkType) + attackBonus;
    }

    /**
     * Gets the elemental type of pokemon which is either fire, water, or grass from superclass Pokemon.
     * @return the type of pokemon.
     */
    public int getType()
    {
        return super.getType();
    }
}
