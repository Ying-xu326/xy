package com.feidian.demo.dao;


import com.feidian.demo.enitity.Contact;
import com.feidian.demo.enitity.Member;
import com.feidian.demo.enitity.Others;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OthersDao {
    List<Contact> queryContact();
    String queryCulture();

}
