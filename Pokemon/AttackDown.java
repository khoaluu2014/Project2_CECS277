/**
 *  Decoration class AttackDown extends from PokemonDecorator and overrides Pokemon class's methods.
 */
public class AttackDown extends PokemonDecorator {
    /**
     * Calls in superclass PokemonDecorator which adds '+ATK' next to the pokemon's name when it is debuffed
     * @param p, pokemon.
     */
    public AttackDown(Pokemon p){
        super(p, "-ATK", 0);
    }

    /**
     * Gets random attack bonus which is the decrease of pokemon's damage by random 1.
     * @param atkType, passed in but not used in this method.
     * @return attackBonus to be added to the calculated damage.
     */
    @Override
    public int getAttackBonus(int atkType){
        return super.getAttackBonus(atkType)-1;
    }
}