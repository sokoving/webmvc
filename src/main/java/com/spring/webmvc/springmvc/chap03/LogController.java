package com.spring.webmvc.springmvc.chap03;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class LogController {
/*
    # 로그의 레벨
- 개발 과정 중에는 수많은 로그를 남기게 되는데
- 운영 중에는 필요 없는 로그도 있고 꼭 봐야 하는 로그가 있다
1. TRACE : 로컬 피씨에서 테스트
2. DEBUG : 개발 서버에서 찍는 로그
3. INFO : 운영 서버에서 찍는 로그 (일반 운영에 )
4. WARN : 경고사항에 대한 로그
5. ERROR : 에러 상황에 대한 로그

*/

    @RequestMapping("/log/test")
    @ResponseBody // 클라이언트에게 직접 데이터 응답
    public String logTest(){
        System.out.println("System.out.println");
        log.trace("log trace!!");
        log.debug("log debug!!");
        log.warn("log warn!!!");
        log.error("log error!!!!!");

        try {
            log.info("try : info log");
            throw new Exception();
        } catch (Exception e) {
            log.error("try catch : error log");
        }

        return "hello";
    }


}
