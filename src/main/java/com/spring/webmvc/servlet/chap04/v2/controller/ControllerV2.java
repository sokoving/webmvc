package com.spring.webmvc.servlet.chap04.v2.controller;

import com.spring.webmvc.servlet.chap04.View;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV2 {

    // 서블릿 스펙 받기
    View process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
