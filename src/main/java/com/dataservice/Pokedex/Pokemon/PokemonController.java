package com.dataservice.Pokedex.Pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class PokemonController {

    @Autowired
    private PokemonDaoService pokemon;

    @GetMapping(path = "/pokemon")
    public List<Pokemon> GetAllPokemons() {
        return PokemonDaoService.GetAllPokemons();
    }

    @GetMapping(path = "/pokemon/{id}")
    public EntityModel<Pokemon> GetPokemon(@PathVariable int id) {
        Pokemon poke = PokemonDaoService.GetPokemon(id);
        if (poke == null) {
            throw new PokeNotFoundException("Missingno");
        }
        EntityModel<Pokemon> model = new EntityModel<>(poke);
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).GetAllPokemons());
        model.add(linkTo.withRel("all-pokemons"));
        return model;
    }

    @PostMapping("/pokemon")
    public ResponseEntity<Object> AddPokemon(@Valid @RequestBody Pokemon poke) {
        Pokemon addedPokemon = PokemonDaoService.AddPokemon(poke);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addedPokemon.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }



    @DeleteMapping(path = "/pokemon/{id}")
    public ResponseEntity<Object> DeletePokemon(@PathVariable int id) {
        Pokemon poke = PokemonDaoService.DeletePokemon(id);
        if (poke.getId() == 0) {
            throw new PokeNotFoundException("Missingno");
        }

        return ResponseEntity.ok(poke);
    }
}
