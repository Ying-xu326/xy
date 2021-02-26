package com.feidian.demo.dao;


import com.feidian.demo.enitity.Member;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MemberDao {
    List<Member> queryMember();
    Member queryMemberById(Integer memberId);
    int insertMember(Member member);
    int updateMember(Member member);
    int deleteMember(Member member);
}
