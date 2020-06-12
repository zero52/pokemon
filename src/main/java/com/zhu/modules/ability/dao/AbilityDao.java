package com.zhu.modules.ability.dao;/*
2019/11/29
41586
*/

import com.zhu.modules.ability.entity.Ability;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value ="abilityDao")
public interface AbilityDao {

    List<Ability> findList(Ability ability);
}
