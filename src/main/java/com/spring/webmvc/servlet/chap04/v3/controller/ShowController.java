package com.spring.webmvc.servlet.chap04.v3.controller;

import com.spring.webmvc.servlet.chap04.ModelAndView;
import com.spring.webmvc.servlet.member.model.Member;
import com.spring.webmvc.servlet.member.repository.MemberRepository;
import com.spring.webmvc.servlet.member.repository.MemoryMemberRepo;

import java.util.List;
import java.util.Map;

public class ShowController implements ControllerV3 {
    MemberRepository repository
            = MemoryMemberRepo.getInstance();

    @Override
    public ModelAndView process(Map<String, String> paramMap) {
        List<Member> members = repository.findAll();
        ModelAndView mv = new ModelAndView("members");
        mv.addAttribute("mList", members);
        return mv;
    }
}
