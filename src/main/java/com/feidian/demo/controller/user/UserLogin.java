package com.feidian.demo.controller.user;


import com.feidian.demo.enitity.ReturnData;
import com.feidian.demo.enitity.Token;
import com.feidian.demo.enitity.User;
import com.feidian.demo.service.TokenService;
import com.feidian.demo.service.UserService;
import com.feidian.demo.util.CodeUtil;
import com.feidian.demo.util.TokenUtil;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class UserLogin {

    public static String getCapText() {
        return capText;
    }

    private static String capText;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserService userService;

    TokenUtil tokenUtil = new TokenUtil();

    Map<String,Object> modelMap= new HashMap<String, Object>();

    @ResponseBody
    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    public Map<String,Object> isControlUser(HttpServletRequest request) {
        System.out.println("进入登录界面！");
        modelMap.clear();
        String userEmail = CodeUtil.getString(request,"userEmail");
        String userPassword = CodeUtil.getString(request,"userPassword");
        User user = new User();
        user.setUserPassword(userPassword);
        user.setUserEmail(userEmail);
        User user_ = userService.login(user);
        Long userId = user_.getUserId().longValue();
        //新建token
        Token token = new Token();
        token.setUserId(userId);

        String tokenKey;
        //确定用户已经登录了，拥有token
        if(userService.queryUserById(userId.intValue()).getUserLogin() != 0) {
            //String secondToken = tokenService.findByUserId(userId).getToken();
            token = tokenService.findByUserId(userId);
            token = tokenUtil.operateToken(token);
            int Num = tokenService.updateToken(token);
            tokenKey = token.getToken();
        } else {
            //用户第一次登录
            token = tokenUtil.operateToken(token);
            tokenKey = tokenService.insertToken(token);
            user_.setUserLogin(1);
            userService.updateUser(user_);
        }
        //token = tokenUtil.operateToken(token);

        //tokenKey = tokenService.findByUserId(token.getUserId()).getToken();

        System.out.println("用户id" + userId + "Token" + tokenKey);
        if (user_.getUserId() != null&&CodeUtil.checkVerifyCode(request)&&tokenKey.equals(tokenService.findByUserId(userId).getToken())) {
            request.getSession().setAttribute("User",user);
            modelMap.put("errno",0);
            modelMap.put("data",user_);
            modelMap.put("token",tokenKey);
            return modelMap;
        }else {
            modelMap.put("errno",-1);
            modelMap.put("data",null);
            return modelMap;
        }
    }
    @Autowired
    private Producer captchaProducer = null;
    @RequestMapping("/kaptcha")
    public void getKaptchaImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        //生成验证码
        capText = captchaProducer.createText();
        System.out.println(capText);
        //向客户端写出
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
    }
}
