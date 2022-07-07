package com.spring.webmvc.chap04.v1.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV1 {

    // 서블릿 스펙 받기
    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}