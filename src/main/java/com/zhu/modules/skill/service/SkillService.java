package com.zhu.modules.skill.service;

import java.util.List;

import com.zhu.modules.pokemon.entity.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhu.modules.skill.dao.SkillDao;
import com.zhu.modules.skill.entity.Skill;

@Service
@Transactional
public class SkillService {

    @Autowired
    private SkillDao skillDao;

    public List<Skill> findList(Skill entity) {
        List<Skill> list = skillDao.findList(entity);
        return list;
    }

    public Skill get(String id) {
        // TODO 自动生成的方法存根
        return null;
    }

    public void save(Skill entity) {
        skillDao.insert(entity);

    }

    public List<Skill> findListForPokemon(Pokemon entity) {
        List<Skill> list = skillDao.findListForPokemon(entity);
        return list;
    }
}
