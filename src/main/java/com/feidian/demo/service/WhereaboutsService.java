package com.feidian.demo.service;

import com.feidian.demo.enitity.Img;
import com.feidian.demo.enitity.Whereabouts;
import com.feidian.demo.enitity.Whereabouts;

import java.util.List;

public interface WhereaboutsService {
     int deleteImgsUrl(Integer id);
     List<Whereabouts> getImgsUrl();
     int uploadImgsUrl(Whereabouts whereabouts);
}
