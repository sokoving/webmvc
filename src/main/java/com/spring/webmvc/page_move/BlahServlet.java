package com.spring.webmvc.page_move;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/blah")
public class BlahServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 모델에 데이터 담기
        req.setAttribute("msg", "안녕하세요(%{mgs})");
        req.setAttribute("number", 100);
        req.setAttribute("hobbys", Arrays.asList("수영", "독서", "측구"));
//        req.setAttribute("hobbys", Arrays.asList());


        // WEB-INF 패키지 안의 페이지는 클라이언트 접근을 차단한다
            // redirect는 클라이언트로 돌아갔다가 페이지로 이동하기 때문에
            // redirect로는 WEB-INF 페이지로 접근이 차단된다
//        resp.sendRedirect("/WEB-INF/blah.jsp");

            // foward는 클라이언트가 /blah 요청 > 서버에서 /WEB-INF/blah.jsp 이동하기 때문에
            // WEB-INF 페이지로 접근이 허용된다
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/blah.jsp");
        rd.forward(req, resp);
    }
}
