package com.feidian.demo.controller.event;
import com.feidian.demo.enitity.Event;
import com.feidian.demo.enitity.Member;
import com.feidian.demo.service.EventService;
import com.feidian.demo.util.EventUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/event")
public class eventController {
    //配置变量
    @Value("${upload_imgs_folder}")
    private String UPLOAD_FOLDER;
    @Value(value = "${IP}")
    private String IP;

    @Autowired
    EventService eventService;

    EventUtil eventUtil = new EventUtil();
    Map<String,Object> modelMap= new HashMap<String, Object>();


    @ResponseBody
    @RequestMapping("/list")
    public Map<String,Object> listEvent() {
        modelMap.clear();
        List list = eventService.queryEvent();
        modelMap.put("errno",0);
        modelMap.put("event",list);
        return modelMap;
    }

    @ResponseBody
    @RequestMapping(value = "/delete",produces="application/json;charset=UTF-8")
    public Map<String,Object> deleteEvent(@RequestBody Event event) {
        //Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.clear();
        Event eventController=eventService. deleteEvent(event);

        if (eventController != null) {
            modelMap.put("errno", 0);
            modelMap.put("data", eventController);
        } else {
            modelMap.put("error", -1);
            modelMap.put("data", null);
        }
        return modelMap;
    }

    @ResponseBody
    @RequestMapping(value = "/add",produces="application/json;charset=UTF-8")
    public Map<String,Object> eventUpload(
//                                          @RequestParam("eventId") Integer eventId,
                                          @RequestParam("eventIntro") String eventIntro,
                                          @RequestParam("eventDate") String eventDate)
    {
        modelMap.clear();
        Event event = eventUtil.EventUploadUtil(eventDate,eventIntro,UPLOAD_FOLDER,IP);
        Event eventController=eventService.addEvent(event);

        if (eventController != null) {
            modelMap.put("errno",0);
            modelMap.put("data",eventController);
        }else {
            modelMap.put("error",-1);
            modelMap.put("data",null);
        }
        return modelMap;
    }
    @ResponseBody
    @RequestMapping(value = "/update",produces="application/json;charset=UTF-8")
    public Map<String,Object> updateMember(
//                                            @RequestParam("event") MultipartFile file,
                                           @RequestParam("eventIntro") String eventIntro,
                                           @RequestParam("eventDate") String eventDate,
                                           @RequestParam("eventId") Integer eventId) {
        modelMap.clear();
        Event event1=eventService.queryEventById(eventId);
        Event event=eventUtil.eventUpdateUtil(eventId,eventDate,eventIntro,event1,UPLOAD_FOLDER,IP);
        Event eventController=eventService.updateEvent(event);

        if (eventController != null) {
            modelMap.put("errno",0);
            modelMap.put("data",eventController);
        }else {
            modelMap.put("error",-1);
            modelMap.put("data",null);
        }

        return modelMap;

    }
}
