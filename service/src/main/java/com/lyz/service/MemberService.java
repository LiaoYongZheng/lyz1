package com.lyz.service;



import com.lyz.domain.Member;
import com.lyz.domain.response.MemberRank;
import com.lyz.domain.response.PaginationBean;

import java.util.List;

public interface MemberService {

    List<MemberRank> findAll(PaginationBean paginationBean);

    public void update(Member member);

    public Member findById(int id);
}
