package com.zhu.modules.skill.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhu.modules.pokemon.web.PokemonController;
import com.zhu.modules.sys.utils.DictUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhu.modules.skill.entity.Skill;
import com.zhu.modules.skill.service.SkillService;

@Controller
@RequestMapping("/a/skill")
public class SkillController {

    //private static final Logger log = LoggerFactory.getLogger(SkillController.class);

    @Autowired
    private SkillService skillService;
	
/*	@ModelAttribute
	public Skill get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			Skill entity = skillService.get(id);
			return entity;
		}
		return new Skill();
	}*/

    @RequestMapping("/list")
    public String list(Skill entity, HttpServletRequest request, HttpServletResponse response, Model model) {
        //skillService.test(entity);
        List<Skill> list = skillService.findList(entity);
        model.addAttribute("list", list);
        request.setAttribute("DictUtils",new DictUtils());
        model.addAttribute("entity", entity);
        return "skill/skillList";
    }

    @RequestMapping("/form")
    public String form(HttpServletRequest request,Skill entity, Model model) {
        request.setAttribute("DictUtils",new DictUtils());
        request.setAttribute("entity", entity);
        return "skill/skillForm";
    }

    @RequestMapping("/save")
    public String save(HttpServletRequest request,Skill entity) {
        skillService.save(entity);
        return "redirect:/a/skill/list";
    }


}
