package com.feidian.demo.controller.message;
import com.feidian.demo.enitity.Event;
import com.feidian.demo.enitity.Message;
import com.feidian.demo.service.MessageService;
import com.feidian.demo.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/message")
public class messageController {
    //配置变量
    @Value("${upload_imgs_folder}")
    private String UPLOAD_FOLDER;
    @Value(value = "${IP}")
    private String IP;

    @Autowired
    MessageService messageService;

    MessageUtil messageUtil = new MessageUtil();
    Map<String,Object> modelMap= new HashMap<String, Object>();


    @ResponseBody
    @RequestMapping("/list")
    public Map<String,Object> listMessage() {
        modelMap.clear();
        List list = messageService.queryMessage();
        modelMap.put("errno",0);
        modelMap.put("message",list);
        return modelMap;
    }


    @ResponseBody
    @RequestMapping(value = "/delete",produces="application/json;charset=UTF-8")
    public Map<String,Object> deleteMessage(@RequestBody Message message) {
        //Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.clear();
        Message messageController=messageService. deleteMessage(message);

        if (messageController != null) {
            modelMap.put("errno", 0);
            modelMap.put("data", messageController);
        } else {
            modelMap.put("error", -1);
            modelMap.put("data", null);
        }
        return modelMap;
    }

    @ResponseBody
    @RequestMapping(value = "/add",produces="application/json;charset=UTF-8")
    public Map<String,Object> messageUpload(
//                                          @RequestParam("messageId") Integer messageId,
                                          @RequestParam("name") String name,
                                          @RequestParam("messageText") String messageText)
    {
        modelMap.clear();
        Message message = messageUtil.MessageUploadUtil(name,messageText,UPLOAD_FOLDER,IP);
        Message messageController=messageService.addMessage(message);

        if (messageController != null) {
            modelMap.put("errno",0);
            modelMap.put("data",messageController);
        }else {
            modelMap.put("error",-1);
            modelMap.put("data",null);
        }
        return modelMap;
    }

    @ResponseBody
    @RequestMapping(value = "/update",produces="application/json;charset=UTF-8")
    public Map<String,Object> updateMember(
//                                            @RequestParam("message") MultipartFile file,
                                           @RequestParam("name") String name,
                                           @RequestParam("messageText") String messageText,
                                           @RequestParam("messageId") Integer messageId) {
        modelMap.clear();
        Message message1=messageService.queryMessageById(messageId);
        Message message=messageUtil.messageUpdateUtil(messageId,name,messageText,message1,UPLOAD_FOLDER,IP);
        Message messageController=messageService.updateMessage(message);

        if (messageController != null) {
            modelMap.put("errno",0);
            modelMap.put("data",messageController);
        }else {
            modelMap.put("error",-1);
            modelMap.put("data",null);
        }

        return modelMap;

    }
}
