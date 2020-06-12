package com.zhu.modules.sys.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhu.modules.sys.entity.Dict;
import com.zhu.modules.sys.service.DictService;

@Controller
@RequestMapping("/a/dict")
public class DictController {

    @Autowired
    private DictService dictService;

    @RequestMapping("/list")
    public String list(Dict entity, HttpServletRequest request, HttpServletResponse response, Model model) {
        List<Dict> list = dictService.findAllDict(entity);
        model.addAttribute("list", list);
        model.addAttribute("entity", entity);
        return "sys/dictList";
    }

    @RequestMapping("/form")
    public String form(Dict entity, Model model) {
        model.addAttribute("entity", entity);
        return "sys/dictForm";
    }

    @RequestMapping("/save")
    public String save(Dict entity) {
        dictService.save(entity);
        return "redirect:" + "/a/dict/list";
    }

    @RequestMapping("/test")
    public String test(HttpServletRequest request, HttpServletResponse response) {

        return "sys/test";
    }

}
