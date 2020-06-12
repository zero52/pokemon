package com.zhu.modules.ability.web;

import com.zhu.modules.ability.entity.Ability;
import com.zhu.modules.ability.service.AbilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wx/ability")
public class WXAbilityController {

//    private static final Logger log = LoggerFactory.getLogger(AbilityController.class);
    @Autowired
    private AbilityService abilityService;

    @RequestMapping("/list")
    public Map<String,Object> list(HttpServletRequest request,Ability ability) {
        List<Ability> list = abilityService.findAll(ability);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("list",list);
        return map;
    }

}
