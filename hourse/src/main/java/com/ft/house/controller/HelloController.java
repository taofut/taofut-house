package com.ft.house.controller;

import com.ft.house.common.model.User;
import com.ft.house.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 创建人：taofut
 * 创建时间：2019-06-30 17:38
 * 描述：
 */
@Controller
public class HelloController {

    @Autowired
    private UserService userService;

    @RequestMapping("hello")
    public String hello(ModelMap modelMap){
        List<User> users=userService.getUsers();
        modelMap.put("user",users.get(0));
        return "hello";
    }

    @RequestMapping("index")
    public String index(){
        return "homepage/index";
    }
}
