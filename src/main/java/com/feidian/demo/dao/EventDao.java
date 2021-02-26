package com.feidian.demo.dao;

import com.feidian.demo.enitity.Event;
import com.feidian.demo.enitity.Img;
import com.feidian.demo.enitity.Member;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EventDao {
    List<Event> queryEvent();
    Event queryEventById(Integer id);
    int insertEvent(Event event);
    int updateEvent(Event event);
    int deleteEvent(Event event);
}