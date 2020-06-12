package com.zhu.modules.sys.service;/*
2019/12/12
41586
*/

import com.zhu.modules.sys.dao.MenuDao;
import com.zhu.modules.sys.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuDao menuDao;

    public List<Menu> findList(Menu entity) {
        return null;
    }

    public void save(Menu entity) {
    }
}
