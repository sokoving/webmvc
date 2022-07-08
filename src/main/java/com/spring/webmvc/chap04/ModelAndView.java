package com.spring.webmvc.chap04;

import lombok.Getter;
import lombok.Setter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

// 뷰, 모델 클래스를 컴포지션해 확장한 클래스 (확장하는 방법 2. 상속)
@Setter @Getter
public class ModelAndView {

    private View view; // 뷰 기능 포함(컴포지션)
    private Model model; // JSP에게 데이터를 전송할 모델매체

    public ModelAndView(String viewName) {
        this.view = new View(viewName);
    }

    // 모델 객체에 데이터를 추가하는 메서드
    public void addAttribute(String key, Object o) {
        model.getModel().put(key, o);
    }

    // 모델 객체의 데이터를 삭제하는 메서드


    public void render(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.view.render(req, resp);
    }

    public Map<String, Object> getModel() {
        return model.getModel();
    }
}