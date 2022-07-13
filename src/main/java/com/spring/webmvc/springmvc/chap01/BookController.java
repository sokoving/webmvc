package com.spring.webmvc.springmvc.chap01;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j2
public class BookController {

    // 책 주문 폼 요청
    @RequestMapping("/book/form")
    public String form(){
        log.info("/book/form GET Request");
        return "chap01/book-form";
    }

    // 책 주문 요청
    @RequestMapping("/book/result")
    public String result(String bookName, int price){
        log.info("/book/result GET - " + bookName + ", " + price);
        return "chap01/book-form";
    }
}
