package com.spring.webmvc.servlet.chap04.v5.controller;

import com.spring.webmvc.servlet.member.model.Member;
import com.spring.webmvc.servlet.member.repository.MemberRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//@RequestMapping("/mvc/v5/*")
//@Controller // 컨트롤러 역할을 하는 @Component
public class MemberController {

    private final MemberRepository repository;

//    @Autowired
    public MemberController(MemberRepository repository) {
        this.repository = repository;
    }


    // 회원 가입 양식 요청 처리
    @RequestMapping("/join")
    public String join() {
        return "reg_form";
    }

    // 회원 가입 실제 저장 처리 요청
    @RequestMapping("/save")
    public String save(Member member) {
        repository.save(member);
        return "redirect:/";
    }

    // 회원 목록 조회 요청
    @RequestMapping("/show")
    public String show(Model model) {
        List<Member> members = repository.findAll();
        model.addAttribute("mList", members);
        return "members";
    }

    // 메인 화면으로 가기
    @RequestMapping("/home")
    public String home(){
        return "redirect:/";
    }

}
