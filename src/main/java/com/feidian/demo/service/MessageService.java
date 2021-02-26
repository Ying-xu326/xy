package com.feidian.demo.service;

import com.feidian.demo.enitity.Message;

import java.util.List;

public interface MessageService {
    List<Message> queryMessage();
    Message queryMessageById(Integer MessageId);
    Message addMessage(Message Message);
    Message deleteMessage(Message Message);
    Message updateMessage(Message Message);

}
