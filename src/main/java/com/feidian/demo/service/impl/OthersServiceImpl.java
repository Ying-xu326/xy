package com.feidian.demo.service.impl;

import com.feidian.demo.dao.MemberDao;
import com.feidian.demo.dao.OthersDao;
import com.feidian.demo.enitity.Contact;
import com.feidian.demo.enitity.Member;
import com.feidian.demo.enitity.Others;
import com.feidian.demo.service.MemberService;
import com.feidian.demo.service.OthersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class OthersServiceImpl implements OthersService {

    @Autowired
    OthersDao othersDao;
    @Override
    public List<Contact> queryContact() {
        return othersDao.queryContact();
    }

    @Override
    public String queryCulture() {
        System.out.println("done");
        System.out.println(othersDao.queryCulture());
        return othersDao.queryCulture();
    }


}
