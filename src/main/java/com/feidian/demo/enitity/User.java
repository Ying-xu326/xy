package com.feidian.demo.enitity;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class User {
    //管理员序号
    private Integer userId;
    //管理员邮箱
    @Email(message = "邮箱格式错误！")
    @NotEmpty(message = "邮箱不能为空！")
    private String userEmail;
    //管理员姓名
    @NotEmpty(message = "输入姓名不能为空！")
    private String userName;
    //管理员密码
    @NotEmpty(message = "密码不能为空！")
    @Length(min=6,message = "密码长度不能小于6位！")
    private String userPassword;
    //管理员初次创立时间
    private Date userCreateTime;
    //管理员最后修改时间
    private Date userLastEditTime;

    //是否是超级管理员
    private Integer userLimit;

    public Integer getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(Integer userLogin) {
        this.userLogin = userLogin;
    }

    //是否已登录
    private Integer userLogin;

    public Integer getUserLimit() {
        return userLimit;
    }

    public void setUserLimit(Integer userLimit) {
        this.userLimit = userLimit;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Date getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(Date userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    public Date getUserLastEditTime() {
        return userLastEditTime;
    }

    public void setUserLastEditTime(Date userLastEditTime) {
        this.userLastEditTime = userLastEditTime;
    }
}
