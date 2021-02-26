package com.feidian.demo.enitity;

public class Member {
    //成员ID
    private Integer memberId;
    //成员姓名
    private String memberName;
    //成员简介
    private String memberIntro;
    //成员头像信息
    private String memberImg;
    //成员头像地址信息
    private String memberImgPath;
    //成员时间
    private String memberYear;

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberIntro() {
        return memberIntro;
    }

    public void setMemberIntro(String memberIntro) {
        this.memberIntro = memberIntro;
    }

    public String getMemberImg() {
        return memberImg;
    }

    public void setMemberImg(String memberImg) {
        this.memberImg = memberImg;
    }

    public String getMemberImgPath() {
        return memberImgPath;
    }

    public void setMemberImgPath(String memberImgPath) {
        this.memberImgPath = memberImgPath;
    }

    public String getMemberYear() {
        return memberYear;
    }

    public void setMemberYear(String memberYear) {
        this.memberYear = memberYear;
    }
}
