package com.zhu.modules.pokemon.web;

import com.zhu.modules.ability.entity.Ability;
import com.zhu.modules.ability.service.AbilityService;
import com.zhu.modules.pokemon.entity.Pokemon;
import com.zhu.modules.skill.entity.Skill;
import com.zhu.modules.skill.service.SkillService;
import com.zhu.modules.sys.utils.DictUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhu.modules.pokemon.service.PokemonService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/a/pokemon")
public class PokemonController {

    private static final Logger log = LoggerFactory.getLogger(PokemonController.class);

    @Autowired
    private PokemonService pokemonService;

    @Autowired
    private SkillService skillService;

    @Autowired
    private AbilityService abilityService;

    @RequestMapping("/list")
    public String test(HttpServletRequest request,Pokemon pokemon) {
        List<Pokemon> list = pokemonService.findAll(pokemon);
//        log.info(list.size()+"");
//        log.info(pokemon.toString());
        request.setAttribute("list",list);
        request.setAttribute("DictUtils",new DictUtils());
        request.setAttribute("pokemon",pokemon);
        return "pokemon/pokemonList";
    }

    @RequestMapping("/skill/form")
    public String pkGetSkill(HttpServletRequest request,Pokemon pokemon){
        //Pokemon entity = pokemonService.get(pokemon);
        //List<Pokemon> pkList = pokemonService.findAll(new Pokemon());
        List<Skill> list = skillService.findListForPokemon(new Pokemon());
        //request.setAttribute("pokemonList",pkList);
        request.setAttribute("pokemon",pokemon);
        request.setAttribute("skillList",list);
        request.setAttribute("DictUtils",new DictUtils());
        //request.setAttribute("pokemon",entity);
        return "pokemon/pokemonSkillAdd";
    }

    @RequestMapping("/skill/add")
    public String pkAddSkill(String pokemonId,String skillIds){
        return "redirect:/pokemon/list";
    }

    @RequestMapping("/add")
    public String pokemonAdd(Pokemon pokemon){
        log.info(pokemon.toString());
        pokemonService.addPokemon(pokemon);
        return "redirect:/a/pokemon/list";
    }

    @RequestMapping("/form")
    public String form(HttpServletRequest request,Pokemon pokemon){
        List<Ability> list = abilityService.findAll(new Ability());
        request.setAttribute("alist",list);
        request.setAttribute("DictUtils",new DictUtils());
        return "pokemon/pokemonForm";
    }

}
