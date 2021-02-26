package com.feidian.demo.controller.others;

import com.feidian.demo.service.MemberService;
import com.feidian.demo.service.OthersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class othersController {
    //配置变量
    @Value("${upload_imgs_folder}")
    private String UPLOAD_FOLDER;
    @Value("${IP}")
    private String IP;

//    @Autowired
//    MemberService memberService
Map<String, Object> modelMap = new HashMap<String, Object>();
    @Autowired
    OthersService othersService;
    @ResponseBody
    @RequestMapping("/contact")
    public Map<String,Object> listContace() {

        modelMap.clear();
        List list = othersService.queryContact();
        modelMap.put("errno", 0);
        modelMap.put("contact", list);
        return modelMap;
    }

    @ResponseBody
    @RequestMapping("/cultureintro")
    public String listCulture() {
        String s=(othersService.queryCulture()).toString();
        return s;
    }



}
