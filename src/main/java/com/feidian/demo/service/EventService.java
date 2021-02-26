package com.feidian.demo.service;

import com.feidian.demo.enitity.Event;
import com.feidian.demo.enitity.Member;

import java.util.List;

public interface EventService {
    List<Event> queryEvent();
    Event queryEventById(Integer eventId);
    Event addEvent(Event event);
    Event deleteEvent(Event event);
    Event updateEvent(Event event);

}
