package com.zhu.modules.sys.web;/*
2019/12/12
41586
*/

import com.zhu.modules.sys.entity.Menu;
import com.zhu.modules.sys.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/a/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/list")
    public String findAll(Menu entity, Model model){
        List<Menu> list = menuService.findList(entity);
        model.addAttribute("list",list);
        model.addAttribute("entity",entity);
        return "/sys/menuList";
    }

    @RequestMapping(value = "/add")
    public String update(Menu entity){
        menuService.save(entity);
        return "redirect:" + "/a/menu/list";
    }

}
