package com.spring.webmvc.chap04.v4.controller;

import com.spring.webmvc.chap04.Model;
import com.spring.webmvc.chap04.ModelAndView;

import java.util.Map;

// 화면 보여주는 컨트롤러 > chap03 Join 서블렛과 같은 역할
public class FormController implements ControllerV4 {

    // 풀경로가 아니라 파일 이름만 전해주고 화면 열기
    @Override
    public String process(Map<String, String> paramMap, Model model) {

        return "reg_form";
    }
}