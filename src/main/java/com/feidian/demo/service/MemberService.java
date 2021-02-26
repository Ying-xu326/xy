package com.feidian.demo.service;

import com.feidian.demo.enitity.Member;
import com.feidian.demo.enitity.News;

import java.util.List;

public interface MemberService {
    List<Member> queryMember();
    Member queryMemberById(Integer memberId);
    Member addMember(Member member);
    Member deleteMember(Member member);
    Member updateMember(Member member);
}
