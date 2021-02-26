package com.feidian.demo.service;


import com.feidian.demo.enitity.User;

import java.util.List;

/**
 * 服务层：实现管理员的判断
 * */


public interface UserService {
    User login(User user);
    List<User> list();
    User addUser(User user);
    int updateUser(User user);
    User deleteUser(User user);
    User queryUserById(Integer userId);
}
