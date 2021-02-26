package com.feidian.demo.dao;

import com.feidian.demo.enitity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {
    List<User> queryUser();
    User queryUserByEmailAndPassword(User user);
    User queryUserByEmail(User user);
    User queryUserById(Integer userId);
    int insertUser(User user);
    int updateUser(User user);
    int deleteUser(Integer userId);
}
