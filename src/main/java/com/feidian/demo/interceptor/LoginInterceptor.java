package com.feidian.demo.interceptor;

import com.feidian.demo.dao.TokenDao;
import com.feidian.demo.enitity.Token;
import com.feidian.demo.util.TokenUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.crypto.SecretKey;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * token拦截器
 *
 * @author sqc
 * @date
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    //@Autowired
    //private TokenDao tokenDao;

    @Autowired
    private TokenDao tokenDao;

    private static TokenDao tokenDao1;

    public @PostConstruct
    void init(){
        tokenDao1 = tokenDao;
    }

    //提供查询
    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {}
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {}
    @Override
    public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
        //此处为不需要登录的接口放行"/member/Images","/culture/Images","/work/Images","/team/Images"
        if (arg0.getRequestURI().contains("/api/login") || arg0.getRequestURI().contains("/Images") || arg0.getRequestURI().contains("/culture/Images") || arg0.getRequestURI().contains("/static")) {
            return true;
        }
        return  true;
//        System.out.println(arg0.getRequestURI());
//        System.out.println("拦截器");
//
//        //权限路径拦截
//        //PrintWriter resultWriter = arg1.getOutputStream();
//        // TODO: 有时候用PrintWriter 回报 getWriter() has already been called for this response
//        //换成ServletOutputStream就OK了
//        arg1.setContentType("text/html;charset=utf-8");
//        ServletOutputStream resultWriter = arg1.getOutputStream();
//
//        final String headerToken=arg0.getHeader("token");
//        //判断请求信息
//        if(null==headerToken||headerToken.trim().equals("")){
//            resultWriter.write("你没有token,需要登录".getBytes());
//            arg1.setStatus(401);
//            resultWriter.flush();
//            resultWriter.close();
//            return false;
//        }
//
//        SecretKey secretKey = TokenUtil.generalKey();
//        //解析Token信息
//        try {
//
//            Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(headerToken).getBody();
//            System.out.println("claims"+claims);
//            String tokenUserId=(String)claims.get("userId");
//            System.out.println("提取的id"+tokenUserId);
//
//            Long iTokenUserId = Long.parseLong(tokenUserId);
//            System.out.println(iTokenUserId);
//            //根据userId查找数据库Token
//            Token myToken= tokenDao1.findByUserId(iTokenUserId);
//
//            //System.out.println();
//
//            System.out.println(myToken.getToken());
//            //数据库没有Token记录
//            if(null==myToken) {
//                resultWriter.write("我没有你的token？,需要登录".getBytes());
//                arg1.setStatus(401);
//                resultWriter.flush();
//                resultWriter.close();
//                return false;
//            }
//            //数据库Token与客户Token比较
//            if( !headerToken.equals(myToken.getToken()) ){
//                resultWriter.print("你的token修改过？,需要登录");
//                arg1.setStatus(401);
//                resultWriter.flush();
//                resultWriter.close();
//                return false;
//            }
//            //判断Token过期
//            //Date tokenDate= claims.getExpiration();
////            Date date = new Date();
////            String result1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
////            String result2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(myToken.getBuildTime()*1000);
////            System.out.println(result1 + result2);
////
////            System.out.println(date.getTime() + "   " +myToken.getBuildTime());
//            int overTime=(int)( System.currentTimeMillis()- myToken.getBuildTime()*1000)/1000;
//
//            System.out.println(overTime);
//
//            if(overTime>60*30){
//                resultWriter.write("你的token过期了？,需要登录".getBytes());
//                arg1.setStatus(401);
//                resultWriter.flush();
//                resultWriter.close();
//                return false;
//            }
//
//        } catch (Exception e) {
//            resultWriter.write("反正token不对,需要登录".getBytes());
//            arg1.setStatus(401);
//            resultWriter.flush();
//            resultWriter.close();
//            return false;
//        }
//        //最后才放行
//        return true;
    }

}