package com.spring.webmvc.servlet.chap04.v3.controller;

import com.spring.webmvc.servlet.chap04.ModelAndView;

import java.util.Map;

// 화면 보여주는 컨트롤러
public class FormController implements ControllerV3 {

    // 풀경로가 아니라 파일 이름만 전해주고 화면 열기
    @Override
    public ModelAndView process(Map<String, String> paramMap) {
        return new ModelAndView("reg_form");
    }
}