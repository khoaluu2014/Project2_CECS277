public class HpUp  extends PokemonDecorator{

    public HpUp(Pokemon p){
        super(p, "+ATK", Rand.randIntRange(1, 2));
    }
}
