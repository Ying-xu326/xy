package com.feidian.demo.dao;

import com.feidian.demo.enitity.Token;
import org.springframework.stereotype.Component;

@Component
public interface TokenDao {
    /* 添加token */
    int insertToken(Token token);

    /* 修改token */
    int updateToken(Token token);

    /* 查询token */
    Token findByUserId(Long userId);

}
