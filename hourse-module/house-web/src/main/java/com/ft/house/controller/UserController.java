package com.ft.house.controller;

import com.ft.house.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建人：taofut
 * 创建时间：2019-06-30 15:50
 * 描述：
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("user")
    public void getUsers(){
        userService.getUsers();
    }

}
