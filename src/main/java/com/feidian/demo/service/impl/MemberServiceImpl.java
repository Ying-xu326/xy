package com.feidian.demo.service.impl;

import com.feidian.demo.dao.MemberDao;
import com.feidian.demo.enitity.Member;
import com.feidian.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberDao memberDao;
    @Override
    public List<Member> queryMember() {
        return memberDao.queryMember();
    }

    @Override
    public Member queryMemberById(Integer memberId) {
        return memberDao.queryMemberById(memberId);
    }

    @Override
    public Member addMember(Member member) {
        int member1=memberDao.insertMember(member);
        if(member1>0){
            return memberDao.queryMemberById(member.getMemberId());
        }else {
            throw new RuntimeException("插入失败！");
        }
    }

    @Override
    public Member deleteMember(Member member) {
        File memberImgToDelete = new File(member.getMemberImgPath());
        memberImgToDelete.delete();
        Member member1=member;
        int member2=memberDao.deleteMember(member);
        if(member2>0){
            return member1;
        }else{
            throw new RuntimeException("删除失败！");
        }
    }

    @Override
    public Member updateMember(Member member) {
        int member1=memberDao.updateMember(member);
        if(member1>0){
            return memberDao.queryMemberById(member.getMemberId());
        }else {
            throw new RuntimeException("更新失败！");
        }
    }
}
