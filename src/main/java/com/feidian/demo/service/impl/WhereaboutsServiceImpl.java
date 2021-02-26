package com.feidian.demo.service.impl;

import com.feidian.demo.dao.ImgDao;
import com.feidian.demo.dao.ImgsDao;
import com.feidian.demo.enitity.Img;
import com.feidian.demo.enitity.Whereabouts;
import com.feidian.demo.service.ImgService;
import com.feidian.demo.service.WhereaboutsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.WatchService;
import java.util.List;

@Component
@Service
public class WhereaboutsServiceImpl implements WhereaboutsService {
    @Autowired
    private ImgsDao imgsDao;

//    @Override
//    public int deleteImgUrl(Img img)  {
//        //需删除Url数据对应的文件，先删除其本地文件
//        Img imgToDeleteUrl = imgDao.getTheImgPath(img);
//        File imgToDelete = new File(imgToDeleteUrl.getImgPath());
//        System.out.println(imgToDeleteUrl.getImgPath());
//        imgToDelete.delete();
//
//        int result = imgDao.deleteImg(img);
//        return result;
//    }
    @Override
    public int deleteImgsUrl(Integer id)  {
        //需删除Url数据对应的文件，先删除其本地文件
//        int whereaboutsID=whereabouts.getWhereaboutsId();
        Whereabouts imgsToDeleteUrl=imgsDao.getTheImgsPath(id);
//        String imgToDeleteUrl=imgsDao.getTheImgsPath(img);
//        System.out.println(imgsToDeleteUrl.getImgsPath());
        File imgsToDelete = new File(imgsToDeleteUrl.getImgsPath());
        System.out.println(imgsToDeleteUrl.getImgsPath());
        imgsToDelete.delete();

        int result2 = imgsDao.deleteImgs(id);
        return result2;
    }

    @Override
    public List<Whereabouts> getImgsUrl() {
        List<Whereabouts> result = imgsDao.getImgs();
        return result;
    }

    @Override
    public int uploadImgsUrl(Whereabouts img) {
        int result = imgsDao.insertImgs(img);
        return result;
    }
}
