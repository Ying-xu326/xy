package com.feidian.demo.service;

import com.feidian.demo.enitity.Img;

import java.util.List;

public interface ImgService {
     int deleteImgUrl(Img img);
     List<Img> getImgUrl();
     int uploadImgUrl(Img img);
}
