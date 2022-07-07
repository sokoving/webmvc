package com.spring.webmvc.page_move;

import org.springframework.core.ReactiveTypeDescriptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/work")
public class WorkServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("work 요청이 들어옴");

        // 1. redirect : 재요청
//      http://localhost:8181/work  > 이동 >  http://localhost:8181/jsp/result.jsp
        resp.sendRedirect("/jsp/result.jsp");
//        resp.sendRedirect("/info");

        // 2. forward : 강제 이동
//        RequestDispatcher rd = req.getRequestDispatcher("/jsp/result.jsp");
//        rd.forward(req, resp);
    }
}
