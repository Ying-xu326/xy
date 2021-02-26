package com.feidian.demo.dao;

import com.feidian.demo.enitity.Whereabouts;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImgsDao {
    List<Whereabouts> getImgs();
    int insertImgs(Whereabouts whereabouts);
    Whereabouts getTheImgsPath(Integer id);
    int deleteImgs(Integer id);
}