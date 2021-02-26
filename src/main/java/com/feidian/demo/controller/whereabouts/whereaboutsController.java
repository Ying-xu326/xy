package com.feidian.demo.controller.whereabouts;


import com.feidian.demo.enitity.Img;
import com.feidian.demo.enitity.Whereabouts;
import com.feidian.demo.service.WhereaboutsService;
import com.feidian.demo.service.impl.WhereaboutsServiceImpl;
import com.feidian.demo.util.ImgUtil;

import com.feidian.demo.util.WhereaboutsUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api")
@Api()
public class whereaboutsController {
    //配置变量
    @Value("${upload_imgs_folder}")
    private String UPLOAD_FOLDER;
    @Value("${IP}")
    private String IP;

    Map<String,Object> modelMap = new HashMap<String, Object>();

    @Autowired
    private WhereaboutsServiceImpl whereaboutsService;

    @ResponseBody
    @RequestMapping(value = "/whereabouts/delete", method = RequestMethod.POST)
    public Map<String,Object> deleteImgs(@RequestParam("whereaboutsId") Integer id)  {
//        int whereaboutsID=whereabouts.getWhereaboutsId();
        System.out.println(id);
        modelMap.clear();
        int result = whereaboutsService.deleteImgsUrl(id);
        if (result > 0) {
            modelMap.put("errno",0);
        }else {
            modelMap.put("error",-1);
        }
        return modelMap;
    }


    @ResponseBody
    @RequestMapping(value = "/whereabouts/imgs", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public List<Whereabouts> getImgsUrl()  {
        List<Whereabouts> result = whereaboutsService.getImgsUrl();
        if(result!=null) {
            return result;
        }
        else {
            return null;
        }
    }

    @ResponseBody
    @PostMapping("whereabouts/upload")
    public Map<String,Object> postImgsUpload(@RequestParam("file") MultipartFile file) {

        modelMap.clear();
        WhereaboutsUtil whereaboutsUtil = new WhereaboutsUtil();
        Whereabouts imgs = whereaboutsUtil.ImageUploadUtil(file,UPLOAD_FOLDER,IP);
        int result = whereaboutsService.uploadImgsUrl(imgs);
        if(result > 0){
            modelMap.put("erron",0);
            return modelMap;
        }
        else {
            modelMap.put("erron",0);
            return modelMap;
        }
    }
}

