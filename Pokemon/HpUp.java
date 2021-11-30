public class HpUp  extends PokemonDecorator{

    public HpUp(Pokemon p){
        super(p, "+HP", Rand.randIntRange(1, 2));
    }
}
