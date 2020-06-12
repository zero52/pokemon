package com.zhu.modules.sys.dao;/*
2019/11/27
41586
*/

import com.zhu.modules.sys.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value ="userDao")
public interface UserDao {
    public User get(User user);
}
