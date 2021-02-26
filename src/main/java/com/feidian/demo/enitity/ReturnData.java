package com.feidian.demo.enitity;

import java.util.List;

public class ReturnData {
    private Integer errno;
    private User data;
    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }


    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }
}
