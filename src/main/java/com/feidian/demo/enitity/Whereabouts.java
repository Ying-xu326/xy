package com.feidian.demo.enitity;

public class Whereabouts {
    private int whereaboutsId;
//    private String imgsFlag;
//    private String imgsTime;
    private String imgsUrl;
    private String imgsPath;

    public void setImgsPath(String imgsPath) { this.imgsPath = imgsPath; }

    public void setWhereaboutsId(int whereaboutsId) {
        this.whereaboutsId = whereaboutsId;
    }

    public void setImgsUrl(String imgsUrl) {
        this.imgsUrl = imgsUrl;
    }
//
//    public void setImgsTime(String imgsTime) {
//        this.imgsTime = imgsTime;
//    }
//
//    public void setImgsFlag(String imgsFlag) {
//        this.imgsFlag = imgsFlag;
//    }

    public int getWhereaboutsId() {
        return whereaboutsId;
    }

    public String getImgsUrl() {
        return imgsUrl;
    }

//    public String getImgsTime() {
//        return imgsTime;
//    }
//
//    public String getImgsFlag() {
//        return imgsFlag;
//    }

    public String getImgsPath() { return imgsPath; }
}
