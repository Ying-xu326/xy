package com.feidian.demo.service;

import com.feidian.demo.enitity.Contact;
import com.feidian.demo.enitity.Member;
import com.feidian.demo.enitity.Others;

import java.util.List;

public interface OthersService {
    List<Contact>queryContact();
//    List<Member> queryMember();
    String queryCulture();
}
