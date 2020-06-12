package com.zhu.modules.pokemon.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zhu.modules.pokemon.entity.Pokemon;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component(value ="pokemonDao")
public interface PokemonDao {

    //@Select("select * from pk_pokemon")
    public List<Pokemon> findList(Pokemon pokemon);

    public void insert(Pokemon pokemon);

    Pokemon get(Pokemon pokemon);
}
