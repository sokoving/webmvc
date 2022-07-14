package com.spring.webmvc.springmvc.chap03;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class RequestController {

    @RequestMapping(value = "/req/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(){
        log.info("/req/hello 요청!");
        return "hello~";
    }

//    @RequestMapping(value = "/req/bye", method = RequestMethod.GET)
    @GetMapping("/req/bye")
    @ResponseBody
    public String bye(){
        log.info("/req/bye 요청!");
        return "bye!";
    }


    @GetMapping("/member/{un}")
    @ResponseBody
    // 쿼리 파라미터로 파라미터 받기
//    public String member(@RequestParam String userName){
    // url에서 파라미터 얻기
//    @PathVariable("un") 별칭 가능, @PathVariable 생략 불가
    public String member(@PathVariable("un") String userName){
        return "I am " + userName;
    }

}
