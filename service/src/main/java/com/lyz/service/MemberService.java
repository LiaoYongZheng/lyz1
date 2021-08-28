package com.lyz.service;



import com.lyz.domain.Member;

import java.util.List;

public interface MemberService {

    List<Member> findAll();

    public void update(Member member);

    public Member findById(int id);
}
