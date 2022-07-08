package com.spring.webmvc.servlet.chap04.v4.controller;


import com.spring.webmvc.servlet.chap04.Model;

import java.util.Map;

public interface ControllerV4 {


    /**
     * 서블릿에서 독립한 컨트롤러 인터페이스 만들기
     * (V2) 요청 정보 자체를 받음
     * (V3) 요청 정보를 frontController가 맵에 담아서 줌
     * (V4) 요청 정보를 맵에, 모델 데이터 모델 객체에 담아서 줌
     * @param paramMap : 요청 정보(쿼리 파라미터)를 모두 읽어서 맵에 담아줌
     * @return 포워딩할 파일명 or 리다이렉트할 경로
     */
    String process(Map<String, String> paramMap, Model model);
}
