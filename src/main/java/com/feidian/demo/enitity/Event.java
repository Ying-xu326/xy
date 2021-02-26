package com.feidian.demo.enitity;

import io.swagger.models.auth.In;

public class Event {
    //事件序号
    private Integer eventId;
    //事件时间
    private String eventDate;
    //时间内容
    private String eventIntro;


    public Integer geteventId() {
        return eventId;
    }

    public void seteventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {this.eventDate = eventDate;}


    public String getEventIntro() {
        return eventIntro;
    }

    public void setEventIntro(String eventIntro) {
        this.eventIntro = eventIntro;
    }


}
