package com.zhu.modules.sys.service;/*
2019/11/27
41586
*/

import com.zhu.modules.sys.dao.UserDao;
import com.zhu.modules.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUser(User user){
        return userDao.get(user);
    }
}
