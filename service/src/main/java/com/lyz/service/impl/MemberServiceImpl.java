package com.lyz.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lyz.domain.Member;
import com.lyz.domain.response.MemberRank;
import com.lyz.domain.response.PaginationBean;
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
    public List<MemberRank> findAll(PaginationBean paginationBean) {
        PageHelper.startPage(paginationBean.getPage(), paginationBean.getSize());
        return iMemberMapper.findAll(paginationBean);
    }

    @Override
    public void update(Member member) {
        try {
            iMemberMapper.update(member);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Member findById(int id) {
        return iMemberMapper.findById(id);
    }
}
