package com.feidian.demo.dao;

import com.feidian.demo.enitity.Img;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Component
public interface ImgDao {
    List<Img> getImg();
    int insertImg(Img img);
    Img getTheImgPath(Img img);
    int deleteImg(Img img);
}