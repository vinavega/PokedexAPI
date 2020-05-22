package com.dataservice.Pokedex.Pokemon;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
@Repository
@Transactional
public class PokemonDaoService {

    @PersistenceContext
    private EntityManager entityManager;

    public long insert(Pokemon poke){
        entityManager.persist(poke);
        return poke.getId();
    }
    private static final List<Pokemon> pokemons = new ArrayList<>();

    static {
        pokemons.add(new Pokemon(1, "Bulbasaur"));
        pokemons.add(new Pokemon(2, "Yvisaur"));
        pokemons.add(new Pokemon(3, "Venusaur"));
        pokemons.add(new Pokemon(4, "Charmander"));
        pokemons.add(new Pokemon(5, "Charmeleon"));
        pokemons.add(new Pokemon(6, "Charizard"));
        pokemons.add(new Pokemon(7, "Squirtle"));
        pokemons.add(new Pokemon(8, "Wartortle"));
        pokemons.add(new Pokemon(9, "Blastoise"));
    }

    public static List<Pokemon> GetAllPokemons() {
        return pokemons;
    }

    public static Pokemon GetPokemon(int id) {
        for (int i = 0; i < pokemons.size(); i++) {
            if (pokemons.get(i).getId() == id) {
                return pokemons.get(i);
            }
        }
        return null;
    }

    public static Pokemon AddPokemon(Pokemon poke) {
        pokemons.add(poke);
        return poke;
    }

    public static Pokemon DeletePokemon(int id) {
        for (int i = 0; i < pokemons.size(); i++) {
            if (pokemons.get(i).getId() == id) {
                Pokemon poke = pokemons.get(i);
                pokemons.remove(i);
                return poke;
            }
        }
        return new Pokemon(0,"Missingno");
    }
}
