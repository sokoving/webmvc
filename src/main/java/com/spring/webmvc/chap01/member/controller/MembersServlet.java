package com.spring.webmvc.chap01.member.controller;

import com.spring.webmvc.chap01.member.model.Member;
import com.spring.webmvc.chap01.member.repository.MemoryMemberRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/members")
public class MembersServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 회원 정보를 서버에서 html을 렌더링하여 응답
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        PrintWriter w = resp.getWriter();

        MemoryMemberRepo memoryMemberRepo = MemoryMemberRepo.getInstance();

        w.write("<!DOCTYPE html>\n");
        w.write("<html>\n");
        w.write("<head>\n");
        w.write("<meta charset=\"UTF-8\">\n");
        w.write("<title>member page</title>\n");
        w.write("<style>label { display: block; }</style>\n");
        w.write("</head>\n");

        w.write("<body>\n");

        // 회원 한 명 정보당 li 태그 하나씩 만듦
        w.write("<ul>");

        List<Member> all = memoryMemberRepo.findAll();

        System.out.println(all.size());

        for (Member member : all) {
            w.write("<li>");
            w.write(String.format("# 회원번호: %s / # 아이디: %s / # 이름: %s", member.getUserNum(), member.getAccount(), member.getUserName()));
            w.write("</li>");
        }

        w.write("</ul>");

        w.write("</body>\n");
        w.write("</html>\n");


    }
}
