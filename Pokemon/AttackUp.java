public class AttackUp extends PokemonDecorator {

        public AttackUp(Pokemon p){
            super(p, "+ATK", 0);
        }

        /**
         * Gets random attack bonus.
         * @param atkType, passed in but not used in this method.
         * @return attackBonus to be added to the calculated damage.
         */
        @Override
        public int getAttackBonus(int atkType){
            return super.getAttackBonus(atkType) + Rand.randIntRange(1,2);
        }
    }