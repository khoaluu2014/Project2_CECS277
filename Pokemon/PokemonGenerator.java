import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class PokemonGenerator {
    private HashMap<String, String> pokemon = new HashMap<>();
    private static PokemonGenerator instance = null;

    public PokemonGenerator() {
        try(Scanner sc = new Scanner(new File("Pokemon/PokemonList.txt"))) {
            while(sc.hasNextLine()) {
                String[] line = sc.nextLine().split(",");
                pokemon.put(line[0], line[1]);
            }
        } catch(FileNotFoundException fnf) {
            System.out.println("File Not Found");
        }
    }

    public static PokemonGenerator getInstance() {
        if(instance != null) {
            return instance;
        }
        else {
            return new PokemonGenerator();
        }
    }

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
