package com.spring.webmvc.servlet.chap01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;

/*
    # 서블릿
    - http 요청과 응답 데이터를 쉽게 처리할 수 있도록 도와주는 자바의 API
    ## 서블릿 구현하기
    1. extends HttpServlet
    2. @WebServlet("/info") > localhost:8181/info 페이지의 데이터 입출력을 담당한다

    ## 서블릿의 단점
    - html 작성이 너무 힘들다
 */
@WebServlet("/info")
public class InfoServlet extends HttpServlet {

    public InfoServlet(){
        System.out.println("\n\n\nInfoServlet container call!\n\n\n");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("info 요청 들어옴");

        //요청 정보 받기 > 서버에서 날아온 정보를 파씽하는 것을 메서드로 간소화시켜줌
        Double height = Double.parseDouble(req.getParameter("height"));
        Double weight = Double.parseDouble(req.getParameter("weight"));

        // 응답 정보 생성하기
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        PrintWriter w = resp.getWriter();

        w.write("<html>");
        w.write("<body>");
        double bmi = bmiCalc(height, weight);
        w.write("<h1> 당신의 bmi 지수는 " + bmi + "군요!</h1>");
        if (bmi >= 25.0) {
            w.write("<h2> 당신은 비만입니다. </h2>");
        } else if (bmi >= 23.0) {
            w.write("<h2> 당신은 과체중입니다. </h2>");
        } else if (bmi >= 18.5) {
            w.write("<h2> 당신은 정상 체중입니다. </h2>");
        } else {
            w.write("<h2> 당신은 저체중입니다. </h2>");
        }
        w.write("</body>");
        w.write("</html>");
    }

    private double bmiCalc(double cm, double kg){
        double m = cm / 100;
        double bmi = kg / (m * m);
        return bmi;
    }
}