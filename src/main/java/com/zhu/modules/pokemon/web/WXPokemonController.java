package com.zhu.modules.pokemon.web;

import com.zhu.modules.ability.service.AbilityService;
import com.zhu.modules.pokemon.entity.Pokemon;
import com.zhu.modules.pokemon.service.PokemonService;
import com.zhu.modules.skill.service.SkillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wx/pokemon")
public class WXPokemonController {

    private static final Logger log = LoggerFactory.getLogger(WXPokemonController.class);

    @Autowired
    private PokemonService pokemonService;

    @RequestMapping("/list")
    public Map<String,Object> test(HttpServletRequest request, Pokemon pokemon) {
        List<Pokemon> list = pokemonService.findAll(pokemon);
//        log.info(list.size()+"");
//        log.info(pokemon.toString());
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("list",list);
        return map;
    }


}
