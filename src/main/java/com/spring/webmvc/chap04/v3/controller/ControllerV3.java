package com.spring.webmvc.chap04.v3.controller;


import com.spring.webmvc.chap04.ModelAndView;
import com.spring.webmvc.chap04.View;

import java.util.Map;

public interface ControllerV3 {


    /**
     * 서블릿에서 독립한 컨트롤러 인터페이스 만들기
     * (V2) 요청 정보 자체를 받음 > (V3) 요청 정보를 frontController가 맵에 담아서 줌
     * @param paramMap : 요청 정보(쿼리 파라미터)를 모두 읽어서 맵에 담아줌
     * @return ModelAndView
     *              jsp(뷰 템플릿)에게 보낼 데이터 객체 (Model)과
     *              화면 처리를 위해 객체(View)를 같이 처리하는 객체
     */
    ModelAndView process(Map<String, String> paramMap);
}
