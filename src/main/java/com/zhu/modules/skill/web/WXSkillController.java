package com.zhu.modules.skill.web;

import com.zhu.modules.skill.entity.Skill;
import com.zhu.modules.skill.service.SkillService;
import com.zhu.modules.sys.utils.DictUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wx/skill")
public class WXSkillController {

    //private static final Logger log = LoggerFactory.getLogger(SkillController.class);

    @Autowired
    private SkillService skillService;

    @RequestMapping("/list")
    public Map<String,Object> list(Skill entity, HttpServletRequest request, HttpServletResponse response, Model model) {
        //skillService.test(entity);
        List<Skill> list = skillService.findList(entity);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("list",list);
        return map;
    }

}
