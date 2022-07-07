package com.spring.webmvc.chap01.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// /register-from 요청을 처리할 서블릿 클래스
// 1. extends HttpServlet
// 2. @WebServlet("/register-form") > 서블릿 컨테이너에 자동 등록

// 회원 가입 양식을 보여주고 회원가입 버튼을 누르면 메모리에 저장(DB 연동, SOLID 염두에 둬야 함)
@WebServlet("/register-form")
public class RegisterServlet extends HttpServlet {

    // 핵심 비즈니스 로직
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // 회원가입 폼을 그려야함 (SSR)
        PrintWriter w = resp.getWriter();

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");


        w.write("<!DOCTYPE html>\n");
        w.write("<html>\n");
        w.write("<head>\n");
        w.write("<meta charset=\"UTF-8\">\n");
        w.write("<title>member register</title>\n");
        w.write("<style>label { display: block; }</style>\n");
        w.write("</head>\n");

        w.write("<body>\n");

//        아래 정보를 /reg-process에 제출
//        input의 name의 값은 키가 되고 입력 데이터는 value가 되어 req에 들어간다
//        method='post' > 링크에
        w.write("<form action='/reg-process' method='post'>\n");
        w.write("<label># account: <input type='text' name='account'></label>\n");
        w.write("<label># password: <input type='password' name='password'></label>\n");
        w.write("<label># name: <input type='text' name='userName'></label>\n");
        w.write("<label><button type='submit'>register</button></label>\n");
        w.write("</form>\n");

        w.write("</body>\n");
        w.write("</html>\n");

    }

}
