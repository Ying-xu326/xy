package com.feidian.demo.controller.user;


import com.feidian.demo.enitity.ReturnData;
import com.feidian.demo.enitity.User;
import com.feidian.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 对管理员的增删改查*/
@Controller
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;


    private ReturnData data = new ReturnData();

    @RequestMapping(value = "/add",produces="application/json;charset=UTF-8")
    @ResponseBody
    public ReturnData addUser(@RequestBody User user) {
        User userController = userService.addUser(user);
        if (userController != null) {
            data.setErrno(0);
            data.setData(user);
            return data;
        }else {
            data.setErrno(-1);
            return data;
        }
    }

    @RequestMapping(value = "/delete",produces="application/json;charset=UTF-8")
    @ResponseBody
    public ReturnData deleteUser(@RequestBody User user) {
        User userController = userService.deleteUser(user);
        if (userController != null) {
            data.setErrno(0);
            data.setData(null);
            return data;
        }else {
            data.setErrno(-1);
            data.setData(null);
            return data;
        }
    }

    @RequestMapping(value = "/update",produces="application/json;charset=UTF-8")
    @ResponseBody
    public ReturnData updateUser(@RequestBody User user) {
        int userController = userService.updateUser(user);
        if (userController != 0) {
            data.setErrno(0);
            data.setData(userService.queryUserById(userController));
            return data;
        }else {
            data.setErrno(-1);
            data.setData(user);
            return data;
        }
    }

    @ResponseBody
    @RequestMapping("/list")
    public Map<String,Object> map() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List list = userService.list();
        modelMap.put("user_message", list);
        modelMap.put("errno",0);
        return modelMap;
    }
}
