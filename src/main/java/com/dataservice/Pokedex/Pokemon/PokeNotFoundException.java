package com.dataservice.Pokedex.Pokemon;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PokeNotFoundException extends RuntimeException {
        public PokeNotFoundException(String message){
        super(message);
        }
}
