package com.spring.webmvc.springmvc.chap01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/hw")
public class LogInController {
    /*
        1번 요청: 로그인 폼 화면 열어주기
         - 요청 URL : /hw/s-login-form
         - 포워딩 jsp 파일 경로:  /WEB-INF/views/chap01/s-form.jsp

        2번 요청: 로그인 검증하기
         - 로그인 검증: 아이디를 grape111이라고 쓰고 비번을 ggg9999 라고 쓰면 성공
         - 요청 URL : /hw/s-login-check
         - 포워딩 jsp 파일 경로:  /WEB-INF/views/chap01/s-result.jsp
         - jsp에게 전달할 데이터: 로그인 성공여부, 아이디 없는 경우, 비번 틀린 경우
     */

    //로그인 양식화면을 열어주는 요청처리
    @RequestMapping("/s-login-form")
    public String sLoginForm() {
        return "chap01/s-form";
    }

    // 로그인 검증 요청 처리
    @RequestMapping("/s-login-check")
    public String sLoginCheck(String id, String pw, Model model) {
        String result;

        //검증
        if(id.equals("grape111")){
            if(pw.equals("ggg9999")){
                result = "success";
            } else {
                result = "f-pw";
            }
        } else {
            result = "f-id";
        }
        model.addAttribute("result", result);
        return "chap01/s-result";

    }

        // 로그인 양식 화면을 열어주는 요청 처리2
    @RequestMapping("/s-login-form2")
    public String sLogInForm2(){
        return "chap01/s-result2";
    }

    // 로그인 검증 요청 처리2
    @RequestMapping("/s-login-check2")
    public String sLogInCheck2(String id, String pwd, Model model){

        System.out.println("id = " + id);
        System.out.println("pwd = " + pwd);

        model.addAttribute("idFlag", false);
        model.addAttribute("pwdFlag", false);

        if (id.equals("grape111")){
            // 아이디가 일치할 경우
            model.addAttribute("idFlag", true);
            if (pwd.equals("ggg9999")){
                // 비번이 일치할 경우
                model.addAttribute("pwdFlag", true);
            }
        }

        return "chap01/s-result2";
    }



}

