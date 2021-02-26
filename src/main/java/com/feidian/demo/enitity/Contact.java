package com.feidian.demo.enitity;

public class Contact {
    //    沸点公众号QQ号
    private String qq;
    //沸点负责人联系方式
    private String tel;
    //沸点邮箱
    private String email;
    //沸点QQ群号
    private String qqgroup;
//    序号
//    Integer Id=1;

    public String getEmail() {
        return email;
    }

    public String getQq() {
        return qq;
    }

    public String getQqgroup() {
        return qqgroup;
    }

    public String getTel() {
        return tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public void setQqgroup(String qqgroup) {
        this.qqgroup = qqgroup;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

}
