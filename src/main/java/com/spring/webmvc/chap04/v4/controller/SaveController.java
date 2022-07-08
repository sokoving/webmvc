package com.spring.webmvc.chap04.v4.controller;

import com.spring.webmvc.chap04.Model;
import com.spring.webmvc.chap04.ModelAndView;
import com.spring.webmvc.member.model.Member;
import com.spring.webmvc.member.repository.MemberRepository;
import com.spring.webmvc.member.repository.MemoryMemberRepo;

import java.util.Map;

public class SaveController implements ControllerV4 {

    private final MemberRepository repository = MemoryMemberRepo.getInstance();


    @Override
    public String process(Map<String, String> paramMap, Model model) {
        //1. 프론트컨틀롤러가 준 회원 정보를 적절한 저장소에 저장
        repository.save(new Member(
                paramMap.get("account"),
                paramMap.get("password"),
                paramMap.get("userName")));

        //2. 홈 화면으로 이동 (리다이렉션)
        return "redirect:/";
    }
}
