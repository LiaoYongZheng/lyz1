package com.lyz.service;



import com.lyz.domain.Member;
import com.lyz.domain.response.MemberRank;

import java.util.List;

public interface MemberService {

    List<MemberRank> findAll();

    public void update(Member member);

    public Member findById(int id);
}
