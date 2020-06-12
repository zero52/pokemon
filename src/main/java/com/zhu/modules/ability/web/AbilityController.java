package com.zhu.modules.ability.web;

import com.zhu.modules.ability.entity.Ability;
import com.zhu.modules.ability.service.AbilityService;
import com.zhu.modules.pokemon.entity.Pokemon;
import com.zhu.modules.pokemon.service.PokemonService;
import com.zhu.modules.skill.entity.Skill;
import com.zhu.modules.skill.service.SkillService;
import com.zhu.modules.sys.utils.DictUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/a/ability")
public class AbilityController {

//    private static final Logger log = LoggerFactory.getLogger(AbilityController.class);
    @Autowired
    private AbilityService abilityService;

    @RequestMapping("/list")
    public String list(HttpServletRequest request,Ability ability) {
        List<Ability> list = abilityService.findAll(ability);
        request.setAttribute("list",list);
        request.setAttribute("ability",ability);
        return "/ability/list";
    }

}
