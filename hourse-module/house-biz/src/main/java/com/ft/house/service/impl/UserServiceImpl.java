package com.ft.house.service.impl;

import com.ft.house.common.model.User;
import com.ft.house.mapper.UserMapper;
import com.ft.house.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 创建人：taofut
 * 创建时间：2019-06-30 16:18
 * 描述：
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUsers() {
        return userMapper.selectUsers();
    }
}
