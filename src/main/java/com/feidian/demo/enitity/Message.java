package com.feidian.demo.enitity;

public class Message {
    //寄语编号
    private Integer messageId;
    //学长学姐姓名
    private String name;
    //寄语内容
    private String messageText;


    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId =messageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public String getMessageText(){
        return messageText;
    }

    public void setMessageText(String messageText){
        this.messageText=messageText;
    }


}
