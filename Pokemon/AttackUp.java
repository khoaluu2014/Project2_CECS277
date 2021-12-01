/**
 * Decoration class AttackUp extends from PokemonDecorator and overrides Pokemon class's methods.
 */
public class AttackUp extends PokemonDecorator {
    /**
     * Calls in superclass PokemonDecorator which adds '+ATK' next to the pokemon's name when it is buffed.
     * @param p type of pokemon.
     */
    public AttackUp(Pokemon p){
            super(p, "+ATK", 0);
        }

        /**
         * Gets random attack bonus which is the increase of pokemon's damage by random 1-2.
         * @param atkType, passed in but not used in this method.
         * @return attackBonus to be added to the calculated damage.
         */
        @Override
        public int getAttackBonus(int atkType){
            return super.getAttackBonus(atkType) + Rand.randIntRange(1,2);
        }
    }