package com.feidian.demo.service.impl;

import com.feidian.demo.dao.MessageDao;
import com.feidian.demo.enitity.Message;
import com.feidian.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageDao messageDao;

    @Override
    public List<Message> queryMessage() {
        return messageDao.queryMessage();
    }

    @Override
    public Message queryMessageById(Integer messageId) {
        return messageDao.queryMessageById(messageId);
    }

    @Override
    public Message addMessage(Message message) {
        int message1=messageDao.insertMessage(message);
        if(message1>0){
            return messageDao.queryMessageById(message.getMessageId());

        }else{
            throw new RuntimeException("插入失败！");
        }
    }

    @Override
    public Message deleteMessage(Message message) {
        Message message1=message;
        int message2=messageDao.deleteMessage(message);
        if(message2>0)
        {
            return message1;
        }else
        {
            throw new RuntimeException("删除失败");
        }
    }


    @Override
    public Message updateMessage(Message message) {

        int message1=messageDao.updateMessage(message);
        if(message1>0){
            return messageDao.queryMessageById(message.getMessageId());
        }else {
            throw new RuntimeException("更新失败！");
        }

    }
}
