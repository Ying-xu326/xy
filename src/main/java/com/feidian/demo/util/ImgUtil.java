package com.feidian.demo.util;

import com.feidian.demo.enitity.Img;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ImgUtil {
    //上传文件夹路径
    String path;
    //新命名
    String newName;
    //文件后缀
    String suffix;
    //获取系统分隔符
    private static String separator = System.getProperty("file.separator");

    public Img ImageUploadUtil(MultipartFile file, String imgTime, String imgFlag, String UPLOAD_FOLDER, String IP) {

        PathUtil(file,imgTime,UPLOAD_FOLDER);

        Img img = new Img();
        if (imgTime.isEmpty()) {
            img.setImgFlag(imgFlag);
            img.setImgPath(path + newName + suffix);
            img.setImgTime(null);
            img.setImgUrl(IP + "/" + imgFlag + "/Images/" + newName + suffix);
        } else {
            img.setImgFlag(imgFlag);
            img.setImgPath(path + newName + suffix);
            img.setImgTime(imgTime);
            img.setImgUrl(IP + "/" + imgFlag + "/Images/" + imgTime + "/" + newName + suffix);
            //System.out.println("file:" + UPLOAD_FOLDER + "team/");
        }
        return img;
    }

    public void PathUtil(MultipartFile file,String imgTime,String UPLOAD_FOLDER) {
        if (!file.isEmpty()) {
            if (imgTime.isEmpty()) {
                path = UPLOAD_FOLDER + "work" + "/";
            } else {
                path = UPLOAD_FOLDER + "team" + "/" + imgTime + "/";
            }
            String[] paths = path.split("/");
            StringBuffer fullPath = new StringBuffer();
            for (int i = 0; i < paths.length; i++) {
                fullPath.append(paths[i]).append("/");
                File tempDir = new File(fullPath.toString());
                if (!tempDir.exists()) {
                    tempDir.mkdir();
                }
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

    /**
     * 获取存放图片路径
     */
    public static String getImgBasePath() {
        // 获取操作系统的信息
        String os = System.getProperty("os.name");
        String basePath = "";
        // 如果是window操作系统
        if (os.toLowerCase().startsWith("win")) {
            basePath = "D:/eclipse/tyron/image"; // Windows系统
        } else {
            basePath = "/home/tyron/image"; // 除了Windows系统
        }

        // 更换分隔符
        basePath = basePath.replace("/", separator);
        return basePath;
    }
}
