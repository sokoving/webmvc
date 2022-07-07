package com.spring.webmvc.chap04.v2;

import com.spring.webmvc.chap04.v2.controller.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// /mvc/v1으로 시작하는 모든 요청을 다 처리하는 하나의 서블렛
@WebServlet("/mvc/v2/*")
public class FrontControllerV2 extends HttpServlet {

    /*
        /mvc/v1/join - 회원가입 폼 요청 > FormController 연결
        /mvc/v1/save - 회원가입 처리 요청 > SaveController 연결
        /mvc/v1/show - 회원 목록 조회 요청 > ShowController 연결
     */

    // 해시맵 사용 : 하위컨트롤러들을 저장, 키값은 URL
    private final Map<String, ControllerV2> controllerMap = new HashMap<>();

    public FrontControllerV2() {
        controllerMap.put("/mvc/v2/join", new FormController());
        controllerMap.put("/mvc/v2/save", new SaveController());
        controllerMap.put("/mvc/v2/show", new ShowController());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 현재 들어온 요청 URI를 반환
        String uri = req.getRequestURI();
        System.out.println("FronControllerV1 요청이 들어옴 : " + uri);

        // 컨트롤러맵에서 방금 들어온 요청에  따른 적합한 컨트롤러를 꺼내옴
        ControllerV2 controller = controllerMap.get(uri);

        if (controller == null){
            resp.setStatus(404); // 404:page not found > 사용자가 잘못된 페이지 uri를 입력함
            return;
        }
        View view = controller.process(req, resp);
        if(view != null) view.render(req, resp);

    }
}
