package com.feidian.demo.enitity;

public class Img {
    private int imgId;
    private String imgFlag;
    private String imgTime;
    private String imgUrl;
    private String imgPath;

    public void setImgPath(String imgPath) { this.imgPath = imgPath; }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setImgTime(String imgTime) {
        this.imgTime = imgTime;
    }

    public void setImgFlag(String imgFlag) {
        this.imgFlag = imgFlag;
    }

    public int getImgId() {
        return imgId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getImgTime() {
        return imgTime;
    }

    public String getImgFlag() {
        return imgFlag;
    }

    public String getImgPath() { return imgPath; }
}
