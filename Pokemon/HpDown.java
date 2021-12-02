/**
 *PokemonDecorator class inherits HpDown method
 */
public class HpDown  extends PokemonDecorator{

    /**
     * Decreases a pokemon's hp and maxHp by 1-2 and adds -HP t the pokemon's name.
     * @param p, type of pokemon
     */

    public HpDown(Pokemon p){

        super(p, "-HP", -1);
    }
}
