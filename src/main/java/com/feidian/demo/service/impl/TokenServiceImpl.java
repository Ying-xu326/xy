package com.feidian.demo.service.impl;

import com.feidian.demo.dao.TokenDao;
import com.feidian.demo.enitity.Token;
import com.feidian.demo.service.TokenService;
import com.feidian.demo.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {
    public static String DatabaseToken;

    @Autowired
    private TokenDao tokenDao;

    @Override
    public Token findByUserId(Long userId) {
        return tokenDao.findByUserId(userId);
    }

    @Override
    public String insertToken(Token token) {
        int tokenNum = tokenDao.insertToken(token);
        if(tokenNum > 0) {
            return token.getToken();
        }
        return null;
    }

    @Override
    public int updateToken(Token token) {
        return tokenDao.updateToken(token);
    }
}
