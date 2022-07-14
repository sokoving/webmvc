# GET과 POST
- 구분하는 것이 중요!
 + get은 주소창에 쿼리가 남고, post는 안 남음
- @RequestMappin
 + method를 지정하지 않으면 get과 post를 구분하지 않고 모든 요청을 받는다
 + @RequestMapping(value = "/req/bye", method = RequestMethod.GET)
- @GetMapping("/req/bye")

- 링크(a태그), 주소창으로 접근하면 GET


## GET
- 클라이언트에서 서버로 어떠한 리소스로부터 정보를 요청하기 위해 사용되는 메서드
- GET을 통한 요청은 URL 주소 끝에 파라미터로 포함되어 전송되며,
- 이 부분을 쿼리 스트링, 쿼리 파라미터이라고 부른다.
- 방식은 URL 끝에 " ? " 를 붙이고 그다음 변수명1=값1&변수명2=값2... 형식으로 이어 붙이면 된다.

- 특징
 1. GET 요청은 캐시가 가능하다.
  - GET을 통해 서버에 리소스를 요청할 때
  - 웹 캐시가 요청을 가로채 서버로부터 리소스를 다시 다운로드하는 대신
  - 리소스의 복사본을 반환한다.
  - HTTP 헤더에서 cache-control 헤더를 통해 캐시 옵션을 지정할 수 있다.
 2. GET 요청은 브라우저 히스토리에 남는다.
 3. GET 요청은 북마크 될 수 있다. 
 4. GET 요청은 길이 제한이 있다.
  - 브라우저마다 다름
 5. GET 요청은 중요한 정보를 다루면 안된다. ( 보안 )
  - GET 요청은 파라미터에 다 노출되어 버리기 때문에 최소한의 보안 의식이라 생각하자.
 6. GET은 데이터를 요청할때만 사용 된다.

## POST
- 클라이언트에서 서버로 리소스를 생성하거나 업데이트하기 위해
 + 데이터를 보낼 때 사용 되는 메서드
- 전송할 데이터를 HTTP 메시지 body 부분에 담아서 서버로 보낸다.
 + body 의 타입은 Content-Type 헤더에 따라 결정 된다.
 + GET에서 URL의 파라미터로 보냈던 name1=value1&name2=value2가 body에 담겨 보내진다 생각하면 된다.
- POST로 데이터를 전송할 때 길이 제한이 따로 없어 용량이 큰 데이터를 보낼 때 사용하거나
 + GET처럼 데이터가 외부적으로 드러나는건 아니라서 보안이 필요한 부분에 많이 사용된다.
 + 데이터를 암호화하지 않으면 body의 데이터도 결국 볼 수 있는건 똑같다.
- POST를 통한 데이터 전송은 보통 HTML form 을 통해 서버로 전송된다.

- 특징
 1. POST 요청은 캐시되지 않는다.
 2. POST 요청은 브라우저 히스토리에 남지 않는다.
 3. POST 요청은 북마크 되지 않는다.
 4. POST 요청은 데이터 길이에 제한이 없다.

-----------------------------------------------------------
# println의 문제점
- 레벨을 설정할 수 없다

# 로그의 레벨
- 개발 과정 중에는 수많은 로그를 남기게 되는데
- 운영 중에는 필요 없는 로그도 있고 꼭 봐야 하는 로그가 있다
1. TRACE : 로컬 피씨에서 테스트
2. DEBUG : 개발 서버에서 찍는 로그
3. INFO : 운영 서버에서 찍는 로그 (일반 운영에 )
4. WARN : 경고사항에 대한 로그
5. ERROR : 에러 상황에 대한 로그
6. FATAL

# 로그 레벨 사용
- @Log4j2
- @Slf4j

# 로그 prinf처럼 쓰기
- log.info("/score/list GET 요청!! - param1 : {}", sort);
  + log.info("/score/list GET 요청!! - param1 : " + sort);
  + 같은 거지만 효율 더 좋음

# 로그 레벨 설정
- resources : application.properties
```
logging.level.root=info
logging.level.com.spring.webmvc.springmvc.chap03.=trace
```

-------------------------------------------------
# @ResponseBody
- 클라이언트에게 직접 데이터 응답
```
 @RequestMapping("/log/test")
    @ResponseBody
    public String logTest(){
        return "hello";
    }
```