# 클래스
## @Controller
- 클래스를 스프링 컨테이너에 빈 등록
- 스프링의 HandlerMapping이 찾아서 DispatcherServlet에 연결함
- 요청을 처리하는 컨트롤러 클래스는 이름에 Controller를 붙여줘 알아보기 쉽게 한다


# 메서드
## @RequestMapping("/spring/about")
- 요청 URL 적기

## 리턴 타입은 String(리다이렉트 혹은 포워딩)
- 포워딩 : return "about";
- 리다이렉트 : return "redirect:/mvc/join"; //jsp파일 리다이렉트



# 요청 파라미터 받기(Query Parameter) 
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
- 요청 파라미터 스펙과 메서드 매개변수 이름이 같으면 @RequestParam 생략 가능
- 예시 /spring/major?stu=kim&major=business&grade=3
```java
@RequestMapping("/spring/major")
    public String major(
            @RequestParam("stu") String stu
            ,String major, int grade
    ) { return ""; }
```

## 방법 3: 커맨드 객체 이용하기 (파라미터가 인수로 나열하기에 너무 많을 때)
``` java
       //ex) /spring/order?oNum=22&goods=구두&amount=3&price=1000
    // 커맨드 객체 사용 시 주의사항
        // 쿼리 파라미터 키값과 커맨드 객체 필드명이 대소문자까지 동일해야 인식함
        // 반드시 setter/getter가 있어야 함  
        // 예시 Order 클래스의 필드 oNum, goods, amount, price
    @RequestMapping("/spring/order")
    public String order(Order order){
        System.out.println("order.getONum() = " + order.getONum());
        System.out.println("order.getGoods() = " + order.getGoods());
        System.out.println("order.getAmount() = " + order.getAmount());
        System.out.println("order.getPrice() = " + order.getPrice());
        return "";
    }```
        