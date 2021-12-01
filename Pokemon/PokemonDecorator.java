/*
@Joshua Peng
*/

/**
 * Abstract PokemonDecorator class extends Pokemon class and has base Pokemon types of Fire, Water, Grass,
 * which will be decorated with different types of buffs and debuffs to change pokemon's damage and hp's.
 * @author Joshua Peng
 */

public abstract class PokemonDecorator extends Pokemon{
    private Pokemon pokemon;

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
     * return@ string menu for basic attacks.
     */
    public String getAttackMenu(int atkType)
    {
        return pokemon.getAttackMenu(atkType);
    }

    /**
     * Gets the number of trainer's choices for the basic attacks menu
     * @return the number of choices for basic attacks menu.
     */
    public int getNumAttackMenuItems(int atkType)
    {
       return pokemon.getNumAttackMenuItems(atkType);
    }
    /**
     * Get the string for the basic attacks that trainer chooses.
     * @param atkType, trainer chooses between basic attack (1) or special attack (2).
     * @param move the move that trainer chooses.
     * @return the string description of the basic attacks that trainer chooses.
     */
    public String getAttackString(int atkType, int move)
    {
        return pokemon.getAttackString(atkType, move);
    }

    /**
     * Gets a random damage from a range which is based on the type of basic attack move.
     * @param atkType, trainer chooses between basic attack (1)  or special attack (2).
     * @param move, the move that trainer chooses.
     * @return the damage amount for the basic attack move.
     */
    public int getAttackDamage(int atkType, int move)
    {
      return pokemon.getAttackDamage(atkType, move);
}

    /**
     * Gets the damage multiplier from Pokemon's class battleTable array for each combination of attack.
     * @param p, wild pokemon that the trainer is fighting with.
     * @param atkType, trainer chooses between basic attack (1) or special attack (2).
     * @return damage multiplier or else returns 1 for basic attack which deals no multiplier.
     */
    public double getAttackMultiplier(Pokemon p, int atkType) {
        return pokemon.getAttackMultiplier(p, atkType);
    }

    /**
     * Gets the attack bonus depending on the type of attack, basic or special.
     * @param atkType, trainer chooses between basic attack (1) or special attack (2).
     * @return attackBonus to be added to the calculated damage.
     */
    @Override
    public int getAttackBonus(int atkType){
        return pokemon.getAttackBonus(atkType);
    }

    /**
     * Gets the elemental type of pokemon which is either fire, water, or grass.
     * @return the type of pokemon.
     */
    public int getType()
    {
        return pokemon.getType();
    }
}