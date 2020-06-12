package com.zhu.modules.sys.web;/*
2019/11/27
41586
*/

import com.zhu.common.utils.AES;
import com.zhu.modules.sys.entity.User;
import com.zhu.modules.sys.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SysController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public String main(){
        return "sys/login";
    }

    @GetMapping(value = "/login")
    public String Login(){
        return "sys/login";
    }

    @PostMapping(value = "/login")
    public String PostLogin(HttpServletRequest request,User user){

        try {

            if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
                throw new RuntimeException("用户名或密码不能为空");
            }

            user.setPassword(AES.encrypt(user.getPassword(),"AOXAvdcOHTIbOgpP"));
            User auth = userService.getUser(user);
            if(auth!=null){
                if(user.getPassword().equals(auth.getPassword())){
                    request.getSession().setAttribute("user",auth);
                }else{
                    throw new RuntimeException("密码错误");
                }

            }else{
                throw new RuntimeException("用户不存在");
            }

            return  "sys/manage";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "sys/login";
    }
}
