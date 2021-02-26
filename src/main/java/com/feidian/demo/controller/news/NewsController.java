package com.feidian.demo.controller.news;

import com.feidian.demo.enitity.News;
import com.feidian.demo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/news")
public class NewsController {
    @Autowired
    NewsService newsService;

    Map<String,Object> modelMap= new HashMap<String, Object>();

    @RequestMapping(value = "/add",produces="multipart/form-data")
    @ResponseBody
    public Map<String,Object> addUser(@RequestBody News news) {
        /*Map<String,Object> modelMap= new HashMap<String, Object>();*/
        modelMap.clear();
        News newsController = newsService.addNews(news);
        if (newsController != null) {
            modelMap.put("errno",0);
            modelMap.put("data",newsController);
        }else {
            modelMap.put("error",-1);
            modelMap.put("data",null);
        }
        return modelMap;
    }

//    @RequestMapping(value = "/delete",produces="application/json;charset=UTF-8")
@RequestMapping(value = "/delete",produces="multipart/form-data")
    @ResponseBody
    public Map<String,Object>  deleteUser(@RequestBody News news) {
        /*Map<String,Object> modelMap=new HashMap<String, Object>();*/
        modelMap.clear();
        News newsController = newsService.deleteNews(news);
        if (newsController != null) {
            modelMap.put("errno",0);
            modelMap.put("data",newsController);
        }else {
            modelMap.put("error",-1);
            modelMap.put("data",null);
        }
        return modelMap;
    }

    @RequestMapping(value = "/update",produces="multipart/form-data")
    @ResponseBody
    public Map<String,Object> updateUser(@RequestBody News news) {
        //Map<String,Object> modelMap=new HashMap<String, Object>();
        modelMap.clear();
        News newsController = newsService.updateNews(news);
        if (newsController != null) {
            modelMap.put("errno",0);
            modelMap.put("data",newsController);
        }else {
            modelMap.put("error",-1);
            modelMap.put("data",null);
        }
        return modelMap;
    }

    @ResponseBody
    @RequestMapping("/list")
    public Map<String,Object> map() {
        //Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.clear();
        List list = newsService.queryNews();
        modelMap.put("errno",0);
        modelMap.put("news",list);
        return modelMap;
    }

    @ResponseBody
    @RequestMapping("/search")
    public Map<String,Object> newsTitle(@RequestBody News news) {
        //Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.clear();
        String search ="%" +news.getNewsTitle()+ "%";
        //System.out.println(search);
        List list = newsService.queryNewsByTitle(search);
        modelMap.put("errno",0);
        modelMap.put("news",list);
        return modelMap;
    }
}
