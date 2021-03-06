package com.spring.webmvc.servlet.chap04;

import lombok.Getter;
import lombok.Setter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Setter @Getter
// 뷰를 포워딩하는 기능
public class View {

    private String viewName; // 포워딩할 뷰의 경로
    private String prefix; // 접두사 (ex: /WEB-INF/views/)
    private String suffix; // 접미사 (ex: .jsp)
    private boolean redirect; // 리다이렉트인지 확인(true-리다이렉트 / false-포워드)

    public View(String viewName) {
        this.prefix = "/WEB-INF/views/";
        this.suffix = ".jsp";
        if(!isRedirect(viewName)){
            // 포워딩할 경우 pre, suf 붙여서
            this.viewName = prefix + viewName + suffix;
        } else {
            //리다이렉트면
            this.viewName = viewName.substring(viewName.indexOf(":") + 1);
        }

    }

    //포워딩 기능
    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!this.redirect) {
            RequestDispatcher dp = request.getRequestDispatcher(viewName);
            dp.forward(request, response);
        } else {
            response.sendRedirect(viewName);
        }
    }

    //현재 뷰 네임이 포워딩인지 리다이렉트인지 확인
    private boolean isRedirect(String viewName){
/*        boolean flag = viewName.contains("redirect:");
        if (flag) {
            this.redirect = true;
            return true;
        } else {
            this.redirect = false;
            return false;
        }*/
        return this.redirect = viewName.contains("redirect:");

    }
}
