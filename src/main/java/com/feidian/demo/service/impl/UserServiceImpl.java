package com.feidian.demo.service.impl;

import com.feidian.demo.dao.UserDao;
import com.feidian.demo.enitity.User;
import com.feidian.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 服务层的具体实现方法
 * @Autowried:注入Dao层*/
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;


    @Override
    public User login(User user) {
        return userDao.queryUserByEmailAndPassword(user);
    }

    @Override
    public List<User> list() {
        return userDao.queryUser();
    }

    @Override
    public User addUser(User user) {
        user.setUserLimit(0);
        user.setUserCreateTime(new Date());
        user.setUserLastEditTime(new Date());
        if (user.getUserEmail() != null && !"".equals(user.getUserEmail())) {
            try {
                int userId = userDao.insertUser(user);
                User user1 = userDao.queryUserById(user.getUserId());
                if (userId > 0) {
                    return user1;
                } else {
                    throw new RuntimeException("添加失败！");
                }
            } catch (Exception e) {
                if(e instanceof DuplicateKeyException) {
                    throw new RuntimeException("已存在管理员！");
                }else {
                    throw e;
                }
            }
        }else {
            throw new RuntimeException("输入信息不能为空！");
        }
    }

    @Override
    public int updateUser(User user) {
        user.setUserLastEditTime(new Date());
        if(user.getUserEmail()!=null&&!"".equals(user.getUserEmail())){
            try{
                int userId=userDao.updateUser(user);
                if(userId>0){
                    return userDao.queryUserByEmail(user).getUserId();
                }else {
                    throw new RuntimeException("更新失败！");
                }
            }catch (Exception e){
                if(e instanceof DuplicateKeyException) {
                    throw new RuntimeException("已存在管理员！");
                }else {
                    throw e;
                }
            }
        }else {
            throw new RuntimeException("输入信息不能为空！");
        }
    }

    @Override
    public User deleteUser(User user) {
        User user1=user;
        if(user.getUserId()>0){
            try {
                int userDelete=userDao.deleteUser(user.getUserId());
                if(userDelete>0) {
                    return user1;
                }else {
                    throw new RuntimeException("删除失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("原因："+e.getMessage());
            }
        }else {
            throw new RuntimeException("ID不能为空！");
        }
    }

    @Override
    public User queryUserById(Integer userId) {
        return userDao.queryUserById(userId);
    }
}
