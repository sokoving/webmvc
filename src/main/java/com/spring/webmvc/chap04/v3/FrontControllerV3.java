package com.spring.webmvc.chap04.v3;


import com.spring.webmvc.chap04.View;
import com.spring.webmvc.chap04.v3.controller.ControllerV3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

// /mvc/v3으로 시작하는 모든 요청을 다 처리하는 하나의 서블렛
@WebServlet("/mvc/v3/*")
public class FrontControllerV3 extends HttpServlet {
    private final Map<String, ControllerV3> controllerMap
            = new HashMap<>();

    public FrontControllerV3() {
//        controllerMap.put("/mvc/v3/join", new FormController());
//        controllerMap.put("/mvc/v3/save", new SaveController());
//        controllerMap.put("/mvc/v3/show", new ShowController());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        // 현재 들어온 요청 URI를 반환
        String uri = req.getRequestURI();

        // 컨트롤러맵에서 방금 들어온 요청에 따른 적합한 컨트롤러를 꺼내옴
        ControllerV3 controller = controllerMap.get(uri);

        // null 처리하면 404(페이지를 찾을 수 없음)
        // null 처리 안 하면 500 에러  (java 코드 문제)
        if (controller == null) {
            resp.setStatus(404);
            return;
        }

        // 요청 파라미터(query parameter)를 전부 읽어서 하위 컨트롤러들에게 보내줌
        // key: 파라미터의 key, value: 파라미터의 value
        Map<String, String> paramMap = createParamMap(req);

        View view = controller.process(paramMap);
        if (view != null) view.render(req, resp);

    }

    private Map<String, String> createParamMap(HttpServletRequest req) {
        Map<String, String> paramMap = new HashMap<>();
        Enumeration<String> parameterNames = req.getParameterNames();

        while (parameterNames.hasMoreElements()) {
            String key = parameterNames.nextElement();
            String value = req.getParameter(key);
            paramMap.put(key, value);
        }

        return paramMap;
    }
}