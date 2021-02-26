package com.feidian.demo.controller.memberImg;

import com.feidian.demo.enitity.Event;
import com.feidian.demo.enitity.Member;
import com.feidian.demo.service.MemberService;
import com.feidian.demo.util.MemberUtil;
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
@RequestMapping("/api/member")
public class memberImgController {
    //配置变量
    @Value("${upload_imgs_folder}")
    private String UPLOAD_FOLDER;
    @Value("${IP}")
    private String IP;

    @Autowired
    MemberService memberService;

    MemberUtil memberUtil = new MemberUtil();
    Map<String,Object> modelMap= new HashMap<String, Object>();

    @ResponseBody
    @RequestMapping("/list")
    public Map<String,Object> listMember() {
        //Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.clear();
        List list = memberService.queryMember();
        modelMap.put("errno",0);
        modelMap.put("member",list);
        return modelMap;
    }
    @ResponseBody
    @RequestMapping(value = "/delete",produces="application/json;charset=UTF-8")
    public Map<String,Object> deleteMember(@RequestBody Member member) {
        //Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.clear();
        Member memberController = memberService.deleteMember(member);
        if (memberController != null) {
            modelMap.put("errno", 0);
            modelMap.put("data", memberController);
        } else {
            modelMap.put("error", -1);
            modelMap.put("data", null);
        }
        return modelMap;
    }

        @ResponseBody
    @RequestMapping(value = "/add",produces="application/json;charset=UTF-8")
    public Map<String,Object> memberImgUpload(@RequestParam("memberImg") MultipartFile file, @RequestParam("memberName") String memberName,
                                              @RequestParam("memberIntro") String memberIntro,@RequestParam("memberYear") String memberYear) {
        modelMap.clear();
        Member member = memberUtil.MemberUploadUtil(file, memberYear, memberName, memberIntro, UPLOAD_FOLDER, IP);

        Member memberController=memberService.addMember(member);
        if (memberController != null) {
            modelMap.put("errno",0);
            modelMap.put("data",memberController);
        }else {
            modelMap.put("error",-1);
            modelMap.put("data",null);
        }
        return modelMap;
    }
    @ResponseBody
    @RequestMapping(value = "/update",produces="application/json;charset=UTF-8")
    public Map<String,Object> updateMember(@RequestParam("memberImg") MultipartFile file, @RequestParam("memberName") String memberName,
                                           @RequestParam("memberIntro") String memberIntro,@RequestParam("memberYear") String memberYear,
                                           @RequestParam("memberId") Integer memberId) {
        modelMap.clear();
        Member member1 = memberService.queryMemberById(memberId);
        Member member = memberUtil.memberUpdateUtil(file, memberYear, memberName, memberIntro, memberId, member1, UPLOAD_FOLDER, IP);
        Member memberController=memberService.updateMember(member);
        if (memberController != null) {
            modelMap.put("errno",0);
            modelMap.put("data",memberController);
        }else {
            modelMap.put("error",-1);
            modelMap.put("data",null);
        }
        return modelMap;
    }
}
