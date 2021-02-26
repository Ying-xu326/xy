package com.feidian.demo.controller.imgController;

import com.feidian.demo.enitity.Img;
import com.feidian.demo.service.ImgService;
import com.feidian.demo.util.ImgUtil;

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
public class ImgController {
    //配置变量
    @Value("${upload_imgs_folder}")
    private String UPLOAD_FOLDER;
    @Value("${IP}")
    private String IP;

    Map<String,Object> modelMap = new HashMap<String, Object>();

    @Autowired
    private ImgService imgService;

    @ResponseBody
    @RequestMapping(value = "/culture/delete", method = RequestMethod.POST)
    public Map<String,Object> deleteImg(@RequestBody Img img)  {
        modelMap.clear();
        int result = imgService.deleteImgUrl(img);
        if (result > 0) {
            modelMap.put("errno",0);
        }else {
            modelMap.put("error",-1);
        }
        return modelMap;
    }

    @ResponseBody
    @RequestMapping(value = "/culture/imgs", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public List<Img> getImgUrl()  {
        List<Img> result = imgService.getImgUrl();
        if(result!=null) {
            return result;
        }
        else {
            return null;
        }
    }

    @ResponseBody
    @PostMapping("/upload")
    public Map<String,Object> postImgUpload(@RequestParam("file") MultipartFile file, @RequestParam("year") String imgTime, @RequestParam("flag") String imgFlag) {

        modelMap.clear();
        ImgUtil imgUtil = new ImgUtil();
        Img img = imgUtil.ImageUploadUtil(file,imgTime,imgFlag,UPLOAD_FOLDER,IP);
        int result = imgService.uploadImgUrl(img);
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

