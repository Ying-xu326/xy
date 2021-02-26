package com.feidian.demo.util;

import com.feidian.demo.enitity.Event;
import com.feidian.demo.enitity.Member;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventUtil {
    //上传文件夹路径
    String path;
    //新命名
    String newName;
    //文件后缀
    String suffix;
    //获取系统分隔符
    private static String separator = System.getProperty("file.separator");

    //装填路径信息
    public Event EventUploadUtil(String eventDate, String eventIntro, String UPLOAD_FOLDER, String IP) {

//        PathUtil(UPLOAD_FOLDER, eventDate);
        Event event = new Event();
//        event.seteventId(eventId);
        event.setEventDate(eventDate);
        event.setEventIntro(eventIntro);
        return event;
    }


//    public void PathUtil(String UPLOAD_FOLDER, String eventDate) {
////        if (!file.isEmpty()) {
////            path = UPLOAD_FOLDER + "event" + "/" + eventDate + "/";
////        }
//        //创建多级文件夹
//        String[] paths = path.split("/");
//        StringBuffer fullPath = new StringBuffer();
//        for (int i = 0; i < paths.length; i++) {
//            fullPath.append(paths[i]).append("/");
//            File tempDir = new File(fullPath.toString());
//            if (!tempDir.exists()) {
//                tempDir.mkdir();
//            }
//        }
//
//        //文件流操作
//        BufferedOutputStream out = null;
//        try {
//            out = new BufferedOutputStream(
//                    new FileOutputStream(path + file.getOriginalFilename()));
//            out.write(file.getBytes());
//            out.flush();
//            out.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //用当前时间重命名文件
//        String fileName = file.getOriginalFilename();
//        suffix = fileName.substring(fileName.lastIndexOf("."));
//        File oldFile = new File(path + file.getOriginalFilename());
//        Date now = new Date();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");//修改日期格式
//        newName = dateFormat.format(now);
//        File newFile = new File(path + newName + suffix);
//        oldFile.renameTo(newFile);
//    }
//
    public Event eventUpdateUtil(Integer eventId,String eventDate, String eventIntro,Event event, String UPLOAD_FOLDER, String IP) {
        event.seteventId(eventId);
        if (!eventDate.isEmpty()) event.setEventDate(eventDate);
        if (!eventIntro.isEmpty()) event.setEventIntro(eventIntro);

        //文件判断必须放在最后
//        if(!file.isEmpty()) {
//
//
//            PathUtil(file, UPLOAD_FOLDER, eventDate);
//            //装填新的事件路径
//            Event event1=EventUploadUtil(file, eventDate, eventIntro, UPLOAD_FOLDER, IP);
//            event1.seteventId(eventId);
//            return event1;

//    }
        return event;}}

//}
