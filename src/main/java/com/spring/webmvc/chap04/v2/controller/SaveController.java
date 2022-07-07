package com.spring.webmvc.chap04.v2.controller;

import com.spring.webmvc.chap04.v1.controller.ControllerV1;
import com.spring.webmvc.chap04.v2.View;
import com.spring.webmvc.member.model.Member;
import com.spring.webmvc.member.repository.MemberRepository;
import com.spring.webmvc.member.repository.MemoryMemberRepo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SaveController implements ControllerV2 {

    @Override
    public View process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberRepository repository = MemoryMemberRepo.getInstance();

        //1. 회원가입 폼에서 날아온 회원 데이터 가져오기
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String userName = request.getParameter("userName");

        //2. 회원 정보를 적절한 저장소에 저장
        Member member = new Member(account, password, userName);
        repository.save(member);

        //3. 홈 화면으로 이동 (리다이렉션)
        response.sendRedirect("/");

        return null;
    }
}
