package com.zhu.modules.skill.dao;

import java.util.List;

import com.zhu.modules.pokemon.entity.Pokemon;
import org.apache.ibatis.annotations.Mapper;

import com.zhu.modules.skill.entity.Skill;
import org.springframework.stereotype.Component;

@Mapper
@Component(value ="skillDao")
public interface SkillDao {

    List<Skill> findList(Skill entity);

    void insert(Skill entity);

    List<Skill> findListForPokemon(Pokemon entity);
}
