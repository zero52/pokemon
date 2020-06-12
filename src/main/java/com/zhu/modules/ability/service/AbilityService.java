package com.zhu.modules.ability.service;

import com.zhu.modules.ability.dao.AbilityDao;
import com.zhu.modules.ability.entity.Ability;
import com.zhu.modules.pokemon.dao.PokemonDao;
import com.zhu.modules.pokemon.entity.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class AbilityService {


    @Autowired
    private AbilityDao abilityDao;

	public List<Ability> findAll(Ability ability){
	    return abilityDao.findList(ability);
    }

}
