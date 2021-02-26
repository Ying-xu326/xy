package com.feidian.demo.enitity;


public class Token {
    /* tokenId */
    private Integer tokenId;

    /* 用户ID */
    private Long userId;

    /* 刷新时间 */
    private Long buildTime;

    /* token */
    private String token;

    public Integer getTokenId() {
        return tokenId;
    }

    public void setTokenId(Integer tokenId) {
        this.tokenId = tokenId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(Long buildTime) {
        this.buildTime = buildTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
