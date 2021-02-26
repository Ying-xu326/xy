package com.feidian.demo.util;

import com.feidian.demo.enitity.Img;
import com.feidian.demo.enitity.Whereabouts;
import jdk.nashorn.api.scripting.ScriptObjectMirror;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class WhereaboutsUtil {
    //上传文件夹路径
    String path;
    //新命名
    String newName;
    //文件后缀
    String suffix;
    //获取系统分隔符
    private static String separator = System.getProperty("file.separator");

    public Whereabouts ImageUploadUtil(MultipartFile file,  String UPLOAD_FOLDER, String IP) {

        PathUtil(file,UPLOAD_FOLDER);

        Whereabouts imgs = new Whereabouts();
//        ScriptObjectMirror imgsTime;
//        if (imgTime.isEmpty()) {
//            imgs.setImgsFlag(imgFlag);
//            imgs.setImgsPath(path + newName + suffix);
//            imgs.setImgsTime(null);
//            imgs.setImgsUrl(IP + "/" + imgFlag + "/Images/" + newName + suffix);
//        } else {
//            imgs.setImgsFlag(imgFlag);
            imgs.setImgsPath(path + newName + suffix);
//            imgs.setImgsTime(imgTime);
            imgs.setImgsUrl(IP +  "/Images/"  + newName + suffix);
            //System.out.println("file:" + UPLOAD_FOLDER + "team/");
//        }
        return imgs;
    }

    public void PathUtil(MultipartFile file,String UPLOAD_FOLDER) {
        if (!file.isEmpty()) {

                path = UPLOAD_FOLDER  ;

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
     *
     */
    public static String getImgBasePath() {
        // 获取操作系统的信息
        String os = System.getProperty("os.name");
        String basePath = "";
        // 如果是window操作系统
        if (os.toLowerCase().startsWith("win")) {
            basePath = "D:/feidian2/image"; // Windows系统
        } else {
            basePath = "/home/tyron/image"; // 除了Windows系统
        }

        // 更换分隔符
        basePath = basePath.replace("/", separator);
        return basePath;
    }
}
