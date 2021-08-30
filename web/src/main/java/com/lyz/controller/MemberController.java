package com.lyz.controller;



import com.lyz.domain.Member;
import com.lyz.domain.response.MemberRank;
import com.lyz.domain.response.ResultInfo;
import com.lyz.service.MemberService;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/member")
@CrossOrigin
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<MemberRank> memberList = memberService.findAll();
        mv.addObject("memberList",memberList);
        System.out.println(memberList);
        mv.setViewName("member-list");
        return mv;
    }
    @GetMapping("/{id}.do")
    @ResponseBody
    public ResultInfo findById(@PathVariable("id")String id){

        Member member = memberService.findById(Integer.parseInt(id));
        if (member == null){
            return new ResultInfo(false,"查询失败");
        }
        return new ResultInfo(true,member,"查询成功");
    }
    @PostMapping("/update.do")
    @ResponseBody
    public ResultInfo update(@RequestBody Member member){
        System.out.println(member);
        return new ResultInfo(true,member,"查询成功");
    }
}
