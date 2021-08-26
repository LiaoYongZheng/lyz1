package com.lyz.controller;



import com.lyz.domain.Member;
import com.lyz.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Member> memberList = memberService.findAll();
        mv.addObject("memberList",memberList);
        System.out.println(memberList);
        mv.setViewName("member-list");
        return mv;
    }

}
