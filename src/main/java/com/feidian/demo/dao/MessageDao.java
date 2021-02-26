package com.feidian.demo.dao;

//import com.feidian.demo.enitity.message;
import com.feidian.demo.enitity.Message;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MessageDao {
    List<Message> queryMessage();

    Message queryMessageById(Integer id);

    int insertMessage(Message message);

    int updateMessage(Message message);

    int deleteMessage(Message message);
}

