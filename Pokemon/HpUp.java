/**
 *PokemonDecorator class inherits HpUp method
 */
public class HpUp  extends PokemonDecorator{


    /**
     * Increases a pokemon's hp and maxHp by 1-2 and adds +HP t the pokemon's name.
     * @param p type of pokemon
     */
    public HpUp(Pokemon p){
        super(p, "+HP", Rand.randIntRange(1, 2));
    }
}
