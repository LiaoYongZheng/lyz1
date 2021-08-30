package com.lyz.service.impl;


import com.lyz.domain.Member;
import com.lyz.domain.response.MemberRank;
import com.lyz.mapper.IMemberMapper;
import com.lyz.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private IMemberMapper iMemberMapper;
    @Override
    public List<MemberRank> findAll() {
        return iMemberMapper.findAll();
    }

    @Override
    public void update(Member member) {

    }

    @Override
    public Member findById(int id) {
        return iMemberMapper.findById(id);
    }
}
