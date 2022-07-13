## 1. @Controller
- 클래스를 스프링 컨테이너에 빈 등록
- 스프링의 HandlerMapping이 찾아서 DispatcherServlet에 연결함
- 요청을 처리하는 컨트롤러 클래스는 이름에 Controller를 붙여줘 알아보기 쉽게 한다


## 2. @RequestMapping("/spring/about")
- 메서드 선언 윗줄에 요청 URL 적기
 + /spring/about 요청이 들어오면 해당 메서드는 실행시킨다
- 클래스에 @RequestMapping("/spring") 하면 하위 컨트롤러에는 /spring 안 써도 됨

## 3. return "redirect:/mvc/join"
- 메서드 리턴값으로 리다이렉트/포워딩할 페이지의 경로를 String 타입으로 적는다
 + 접미에 WEB-INF/views 자동 삽입됨(그 다음 경로부터 쓰기)
 + 접두에 .jsp 자동 삽입
- 포워딩 : return "about";
- 리다이렉트 : return "redirect:/mvc/join";
```java
            @RequestMapping("/coffee/form")
            public String form(){
                log.info("/coffee/form GET Request");
                return "chap01/coffee-form";
            }
```

## 4. jsp 페이지에서 요청 파라미터 넘기기
- action : 쿼리 파라미터를 넘길 컨트롤러 경로
 + method="get" - 쿼리 파라미터를 url에 띄움
 + method="post - 쿼리 파라미터를 숨김 
- name : 쿼리 파라미터의 key
- value : 쿼리 파라미터의 value
```html
            <form action="/coffee/result" method="post">
                <label>
                    # 주문 목록 <br>
                    <select id="menu-sel" name="menu">
                        <option value="americano">아메리카노</option>
                        <option value="cafeLatte">카페라떼</option>
                        <option value="macchiato">카라멜 마끼아또</option>                        
                    </select>
                </label>
                <label class="price"># 가격: 3000원</label>

                <input id="price-tag" type="hidden" name="price" value="3000">

                <label>
                    <button type="submit">주문하기</button>
                </label>
            </form>
```


# 5. 쿼리 파라미터 받아서 다시 jsp에 건네주기
```java
    @RequestMapping("/coffee/result")
    public String result(String menu, int price, Model model){
        log.info("/coffee/form POST - " + menu +", "+ price);
        model.addAttribute("menu", menu);
        model.addAttribute("p", price);
        return "chap01/coffee-result";
    }
```
```html
            <li># 주문하신 메뉴: ${menu}</li>
            <li># 가격: ${p}</li>
```

# 요청 파라미터 받는 방법(Query Parameter)
- 방법 2  @RequestParam 권장
## 방법 1. HttpServletRequest 사용 (서블릿 스펙받기)
- 예시 /spring/person?name=kim&age=30
```java
        @RequestMapping("/spring/person")
        public String person(HttpServletRequest request) {
            String name = request.getParameter("name");
            String age = request.getParameter("age");
            return "";
        }
```
## 방법 2. @RequestParam 사용
- 쿼리 파라미터 스펙과 메서드 매개변수 이름이 같으면 @RequestParam 생략 가능
- @RequestParam("stu") 으로 별칭 가능
- 예시) /spring/major?stu=kim&major=business&grade=3
```java
        @RequestMapping("/spring/major")
            public String major(String stu, String major, int grade)
        { return ""; }

        @RequestMapping("/spring/major")
            public String major(@RequestParam("stu") String stu
                                , @RequestParam String major
                                , @RequestParam int grade)
        { return ""; }
```

## 방법 3: 커맨드 객체 이용하기 (파라미터가 인수로 나열하기에 너무 많을 때)
- 커맨드 객체 사용 시 주의사항
 + 쿼리 파라미터 키값과 커맨드 객체 필드명이 대소문자까지 동일해야 인식함
 + 반드시 setter/getter가 있어야 함  
- ex) /spring/order?oNum=22&goods=구두&amount=3&price=1000
 + 예시 Order 클래스의 필드 oNum, goods, amount, price
```java
        @RequestMapping("/spring/order")
        public String order(Order order){
            System.out.println("order.getONum() = " + order.getONum());
            System.out.println("order.getGoods() = " + order.getGoods());
            System.out.println("order.getAmount() = " + order.getAmount());
            System.out.println("order.getPrice() = " + order.getPrice());
            return "";
        }
```
