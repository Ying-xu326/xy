package com.feidian.demo.service.impl;

import com.feidian.demo.dao.EventDao;
import com.feidian.demo.dao.MemberDao;
import com.feidian.demo.enitity.Event;
import com.feidian.demo.enitity.Member;
import com.feidian.demo.service.EventService;
import com.feidian.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventDao eventDao;

    @Override
    public List<Event> queryEvent() {
        return eventDao.queryEvent();
    }

    @Override
    public Event queryEventById(Integer eventId) {
        return eventDao.queryEventById(eventId);
    }

    @Override
    public Event addEvent(Event event) {
        int event1=eventDao.insertEvent(event);
        if(event1>0){
            return eventDao.queryEventById(event.geteventId());

        }else{
            throw new RuntimeException("插入失败！");
        }
    }

    @Override
    public Event deleteEvent(Event event) {
        Event event1=event;
        int event2=eventDao.deleteEvent(event);
        if(event2>0)
        {
            return event1;
        }else
        {
            throw new RuntimeException("删除失败");
        }
    }


    @Override
    public Event updateEvent(Event event) {

        int event1=eventDao.updateEvent(event);
        if(event1>0){
            return eventDao.queryEventById(event.geteventId());
        }else {
            throw new RuntimeException("更新失败！");
        }

    }
}
