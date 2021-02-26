package com.feidian.demo.util;



import com.feidian.demo.enitity.Token;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;


import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

public class TokenUtil {
    //public static String DatabaseToken;

   // @Autowired
   // private TokenDao tokenDao;
   public static final String JWT_SECERT = "0000df7f12334e888889999123c0005d";

    public Token operateToken(Token token) {

        //根据数据库的用户信息查询Token
        //Token token = tokenDao.findByUserId(userId);
        //为生成Token准备
        Long userId = token.getUserId();
        String TokenStr = "";
        Date date = new Date();
        //获得秒数
        long nowTime = date.getTime() / 1000;
        //生成Token
        TokenStr = creatToken(userId, date);

        if (null == token.getToken()) {
            //第一次登陆
            token.setToken(TokenStr);
            token.setBuildTime(nowTime);
            //tokenDao.insertToken(token);
        }else{
            //登陆就更新Token信息
            TokenStr = creatToken(userId, date);
            token.setToken(TokenStr);
            token.setBuildTime(nowTime);
            System.out.println(nowTime);
            //tokenDao.updateToken(token);
        }

        //User queryForm = getUserInfo(user, TokenStr);
        /* 将用户信息存入session */
        /*SessionContext sessionContext = SessionContext.getInstance();
        HttpSession session = sessionContext.getSession();
        httpSession.setAttribute("userInfo", user);*/
        //返回Token信息给客户端
       // successful(map);
        //map.put("data", queryForm);
        //DatabaseToken = tokenDao.findByUserId(userId).getToken();
        return token;
    }




    /**
     * 生成token(格式为token:设备-加密的用户名-时间-六位随机数)
     * @param username 用户登录名
     * @return
     */
    public String creatToken(Long userId, Date date) {
        SecretKey secretKey = generalKey();
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT") // 设置header
                                 .setHeaderParam("alg", "HS256").setIssuedAt(date) // 设置签发时间
                                 .setExpiration(new Date(date.getTime() + 1000 * 60 * 60))
                                 .claim("userId",String.valueOf(userId) ) // 设置内容
                                 .setIssuer("lws")// 设置签发人
                                 .signWith(signatureAlgorithm, secretKey); // 签名，需要算法和key
        String jwt = builder.compact();
        return jwt;
    }

    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.decode(JWT_SECERT);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

}