package com.feidian.demo.util;

import com.feidian.demo.enitity.Img;
import com.feidian.demo.enitity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MemberUtil {
    //上传文件夹路径
    String path;
    //新命名
    String newName;
    //文件后缀
    String suffix;
    //获取系统分隔符
    private static String separator = System.getProperty("file.separator");

    //装填路径信息
    public Member MemberUploadUtil(MultipartFile file, String memberYear, String memberName, String memberIntro, String UPLOAD_FOLDER, String IP) {

        PathUtil(file, UPLOAD_FOLDER, memberYear);
        Member member = new Member();

        member.setMemberYear(memberYear);
        member.setMemberImgPath(path + newName + suffix);
        member.setMemberImg(IP + "/member/Images/" + memberYear + "/" + newName + suffix);
        member.setMemberName(memberName);
        member.setMemberIntro(memberIntro);

        return member;
    }

    public void PathUtil(MultipartFile file, String UPLOAD_FOLDER, String memberYear) {
        if (!file.isEmpty()) {
            path = UPLOAD_FOLDER + "member" + "/" + memberYear + "/";
        }
        //创建多级文件夹
        String[] paths = path.split("/");
        StringBuffer fullPath = new StringBuffer();
        for (int i = 0; i < paths.length; i++) {
            fullPath.append(paths[i]).append("/");
            File tempDir = new File(fullPath.toString());
            if (!tempDir.exists()) {
                tempDir.mkdir();
            }
        }

        //文件流操作
        BufferedOutputStream out = null;
        try {
            out = new BufferedOutputStream(
                    new FileOutputStream(path + file.getOriginalFilename()));
            out.write(file.getBytes());
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //用当前时间重命名文件
        String fileName = file.getOriginalFilename();
        suffix = fileName.substring(fileName.lastIndexOf("."));
        File oldFile = new File(path + file.getOriginalFilename());
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");//修改日期格式
        newName = dateFormat.format(now);
        File newFile = new File(path + newName + suffix);
        oldFile.renameTo(newFile);
    }

    public Member memberUpdateUtil(MultipartFile file, String memberYear, String memberName, String memberIntro,  Integer memberId, Member member, String UPLOAD_FOLDER, String IP){
        member.setMemberId(memberId);
        if(!memberYear.isEmpty()) member.setMemberYear(memberYear);
        if(!memberIntro.isEmpty()) member.setMemberIntro(memberIntro);
        if(!memberName.isEmpty()) member.setMemberName(memberName);

        //文件判断必须放在最后
        if(!file.isEmpty()) {
            //原有头像删除
            File memberImgToDelete = new File(member.getMemberImgPath());
            memberImgToDelete.delete();

            //新增头像
            PathUtil(file, UPLOAD_FOLDER, memberYear);
            //装填新的图像路径
            Member member1 = MemberUploadUtil(file, member.getMemberYear(), member.getMemberName(), member.getMemberIntro(), UPLOAD_FOLDER, IP);
            member1.setMemberId(memberId);
            return member1;
        }
        return member;
    }
}
