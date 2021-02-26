package com.feidian.demo.service;

import com.feidian.demo.enitity.Token;

public interface TokenService {
    Token findByUserId(Long userId);
    String insertToken(Token token);
    int updateToken(Token token);
}
