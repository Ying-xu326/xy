package com.feidian.demo.controller;


import com.feidian.demo.util.CodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class hello {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(HttpServletRequest request) {
        if (!CodeUtil.checkVerifyCode(request)) {
            return "验证码有误！";
        } else {
            return "hello,world";
        }
    }
}
