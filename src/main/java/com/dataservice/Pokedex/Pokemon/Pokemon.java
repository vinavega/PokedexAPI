package com.dataservice.Pokedex.Pokemon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@ApiModel(description = "Detalhes dos pokemons")
@Entity
public class Pokemon {

    @Id
    private int id;

    @Size(min = 1,max = 20)
    @ApiModelProperty(notes="Min = 1, Max = 20")
    private String name;

    public Pokemon() {
    }

    public Pokemon(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
