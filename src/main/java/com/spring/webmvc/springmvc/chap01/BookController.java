package com.spring.webmvc.springmvc.chap01;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
public class BookController {

    // 책 주문 폼 요청
    @RequestMapping("/book/form")
    public String form(){
        log.info("/book/form GET Request");
        return "chap01/book-form";
    }
}
