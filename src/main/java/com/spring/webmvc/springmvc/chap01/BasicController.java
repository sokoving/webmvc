package com.spring.webmvc.springmvc.chap01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller // 클래스를 스프링 컨테이너에 빈 등록
// 스프링의 HandlerMapping이 찾아서 DispatcherServlet에 연결함
public class BasicController {

    // 클라이언트 요청 받기
    @RequestMapping("/spring/about") //요청 URL 적기
    public String about(){
        System.out.println("BasicController : about 요청 들어옴");
        
        // return "/WEB-INf/views/about.jsp 포워딩
        return "about"; //jsp파일 포워딩
    }

    @RequestMapping("/spring/hello") // 요청 URL 적음
    public String hello(){
        System.out.println("BasicController : hello 요청 들어옴");

        // return "/WEB-INf/views/reg_form.jsp 리다이렉트
        return "redirect:/mvc/join"; //jsp파일 리다이렉트
    }

    //======================= 요청 파라미터 받기(Query Parameter) =======================//

    // 방법 1. HttpServletRequest 사용 (서블릿 스펙받기)
        // ex) /spring/person?name=kim&age=30
    @RequestMapping("/spring/person")
    public String person(HttpServletRequest request) {
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        System.out.println("name = " + name);
        System.out.println("age = " + age);

        return "";
    }

    // 방법 2. @RequestParam 사용
        // ex) /spring/major?stu=kim&major=business&grade=3
    @RequestMapping("/spring/major")
    public String major(
            @RequestParam("stu") String stu
            ,@RequestParam("major") String major
            ,@RequestParam("grade") int grade
    ) {
        System.out.println("stu = " + stu);
        System.out.println("major = " + major);
        System.out.println("grade = " + grade);

        return "";
    }

    // 요청 파라미터 스펙과 메서드 매개변수 이름이 같으면
    // @RequestParam 생략 가능
    @RequestMapping("/spring/major2")
    public String major2(String stu, String major, int grade) {
        System.out.println("stu = " + stu);
        System.out.println("major = " + major);
        System.out.println("grade = " + grade);

        return "";
    }

    // 방법 3: 커맨드 객체 이용하기 (파라미터가 인수로 나열하기에 너무 많을 때)
        //ex) /spring/order?oNum=22&goods=구두&amount=3&price=1000
    // 커맨드 객체 사용 시 주의사항
        // 쿼리 파라미터 키값과 커맨드 객체 필드명이 대소문자까지 동일해야 인식함
        // 반드시 setter/getter가 있어야 함  
        // 예시 Order 클래스의 필드 oNum, goods, amount, price
    @RequestMapping("/spring/order")
    public String order(Order order){
        System.out.println("order.getONum() = " + order.getONum());
        System.out.println("order.getGoods() = " + order.getGoods());
        System.out.println("order.getAmount() = " + order.getAmount());
        System.out.println("order.getPrice() = " + order.getPrice());
        return "";
    }
        
        
  
    
}
