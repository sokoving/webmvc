package com.spring.webmvc.chap04.v3.controller;

import com.spring.webmvc.chap04.View;

import java.util.Map;

// 화면 보여주는 컨트롤러
public class FormController implements ControllerV3 {

    @Override
    public View process(Map<String, String> paramMap) {
        return new View("/WEB-INF/views/reg_form.jsp");
    }
}