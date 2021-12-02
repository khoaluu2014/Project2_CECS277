import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

/**
 * PokemonGenerator is a singleton that generates random or specific pokemon & randomly chooses a buff or debuff
 * to apply to a pokemon.
 */
public class PokemonGenerator {
    // Other data member of class. Initializes the Hashmap to store pokemon names and types.
    private HashMap<String, String> pokemon = new HashMap<>();
    // Single PokemonGenerator instance.
    private static PokemonGenerator instance = null;

    /**
     * Reads a pokemon list file into a HashMap to store different pokemon names and their associated
     * elemental type.
     */
    public PokemonGenerator() {
        try(Scanner sc = new Scanner(new File("PokemonList.txt"))) {
            while(sc.hasNextLine()) {
                String[] line = sc.nextLine().split(",");
                pokemon.put(line[0], line[1]);
            }
        } catch(FileNotFoundException fnf) {
            System.out.println("File Not Found");
        }
    }

    /**
     * Gets single PokemonGenerator instance.
     * @return static PokemonGenerator object.
     */
    public static PokemonGenerator getInstance() {
        if(instance != null) {
            return instance;
        }
        else {
            return new PokemonGenerator();
        }
    }

    /**
     * The generateRandomPokemon randomly selects a pokemon from the hashmap and construct a pokemon of the corresponding
     * elemental base type. If level > 1, tt also decorates pokemon with a random buff for each level greater than one.
     * @param level, level for the pokemon.
     * @return random pokemon.
     */
    public Pokemon generateRandomPokemon(int level) {
        Pokemon randomPokemon = null;
        int randomPokemonChoice = Rand.randIntRange(0, pokemon.size()-1);
        Object[] pokemonKey = pokemon.keySet().toArray(new String[0]);
        String randomPokemonName = (String) pokemonKey[randomPokemonChoice];
        String randomPokemonType = pokemon.get(randomPokemonName);

        if(randomPokemonType.equalsIgnoreCase("Fire")) {
            randomPokemon = new Fire(randomPokemonName, 25, 25);
        }
        else if(randomPokemonType.equalsIgnoreCase("Water")) {
            randomPokemon = new Water(randomPokemonName, 25, 25);
        }
        else if(randomPokemonType.equalsIgnoreCase("Grass")) {
            randomPokemon = new Grass(randomPokemonName, 25, 25);
        }
        for(int i = 0; i < level; i++) {
            addRandomBuff(randomPokemon);
        }
        return randomPokemon;
    }

    /**
     * The getPokemon method passes in a string with name of pokemon and constructs an object of corresponding type.
     * @param name of pokemon
     * @return object of corresponding type of pokemon
     */

    public Pokemon getPokemon(String name) {
        String pokemonType = pokemon.get(name);
        Pokemon poke = null;
        if(pokemonType.equalsIgnoreCase("Fire")) {
            poke = new Fire(name, 25, 25);
        }
        else if(pokemonType.equalsIgnoreCase("Water")) {
            poke = new Water(name, 25, 25);
        }
        else if(pokemonType.equalsIgnoreCase("Grass")) {
            poke = new Grass(name, 25, 25);
        }
        return poke;
    }

    /**
     * Randomly chooses the type of buff for the pokemon. Calls in either AttackUp or HpUp methods.
     * @param p, pokemon
     * @return type of buff
     */
    public Pokemon addRandomBuff(Pokemon p) {
        int randomBuff = Rand.randIntRange(1, 2);
        if(randomBuff == 1) {
            p = new AttackUp(p);
        }
        else if(randomBuff == 2) {
            p = new HpUp(p);
        }
        return p;
    }

    /**
     * Randomly chooses the type of debuff for the pokemon. Calls in either AttackDown or HpDown methods.
     * @param p, pokemon
     * @return type of debuff
     */
    public Pokemon addRandomDebuff(Pokemon p) {
        int randomDebuff = Rand.randIntRange(1, 2);

        if(randomDebuff == 1) {
            p = new AttackDown(p);
        }
        else if(randomDebuff == 2) {
            p = new HpDown(p);
        }
        return p;
    }

}
