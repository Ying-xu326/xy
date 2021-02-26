package com.feidian.demo.service.impl;

import com.feidian.demo.enitity.Img;
import com.feidian.demo.dao.ImgDao;
import com.feidian.demo.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class ImgServiceImpl implements ImgService {
    @Autowired
    private ImgDao imgDao;

    @Override
    public int deleteImgUrl(Img img)  {
        //需删除Url数据对应的文件，先删除其本地文件
        Img imgToDeleteUrl = imgDao.getTheImgPath(img);
        File imgToDelete = new File(imgToDeleteUrl.getImgPath());
        System.out.println(imgToDeleteUrl.getImgPath());
        imgToDelete.delete();

        int result = imgDao.deleteImg(img);
        return result;
    }

    @Override
    public List<Img> getImgUrl() {
        List<Img> result = imgDao.getImg();
        return result;
    }

    @Override
    public int uploadImgUrl(Img img) {
        int result = imgDao.insertImg(img);
        return result;
    }
}
