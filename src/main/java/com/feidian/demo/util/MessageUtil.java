package com.feidian.demo.util;

import com.feidian.demo.enitity.Event;
import com.feidian.demo.enitity.Message;

public class MessageUtil {
    //上传文件夹路径
    String path;
    //新命名
    String newName;
    //文件后缀
    String suffix;
    //获取系统分隔符
    private static String separator = System.getProperty("file.separator");

    //装填路径信息
    public  Message MessageUploadUtil(String name, String message2, String UPLOAD_FOLDER, String IP) {

//        PathUtil(UPLOAD_FOLDER, messageDate);
        Message message = new Message();
//        message.setMessageId(messageId);
        message.setName(name);
        message.setMessageText(message2);
        return message;
    }


    public Message messageUpdateUtil(Integer messageId, String name, String message2, Message message, String UPLOAD_FOLDER, String IP) {
        message.setMessageId(messageId);
        if (!name.isEmpty()) message.setName(name);
        if (!message2.isEmpty()) message.setMessageText(message2);

        return message;}}

//}
