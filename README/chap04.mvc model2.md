# 컨트롤러 통합 과정
- 하나의 서블릿으로 여러 요청 처리하기

## V1
1. 모든 요청을 받기 
  > @WebServlet("/*")
2. 요청에 제약 걸기
  > @WebServlet("/mvc/v1/*")
3. 요청 정보가 오는 곳 : HttpServletRequest req
  > @Override protected void service(HttpServletRequest req, HttpServletResponse resp) 
4. 현재 들어온 요청 URI를 반환하는 메서드 
  > req.getRequestURI();
5. chap03의 기능별 서블렛을 컨트롤 파일로 리팩터링
- ControllerV1 임플리먼츠, 공통 메서드 process


chap01 서블릿
chap02 JSP
chap03 
chap04 스프링 mvc 개발 과정
 v1
 v2
 v3

## V2
- 컨트롤러간 공통 코드 리팩터링

## V3
- view, 컨틀롤러 클래스에서 서블릿 요소 뻬내기
## V4
- 리턴 타입 ModelAndView > String


# 프론트 컨트롤러 MVC 패턴
1. 클라이언트로부터의 요청
 - 무슨 요청이든 간에 단일 진입점에서 요청을 받는다 > 프론트 컨트롤러 팬턴
2. 프론트 컨트롤러
- 무슨 요청인지 분석
- 요청을 분석해 각자 컨트롤러에 배분
- url을 키, 컨트롤러를 값으로 한 맵 생성
- 키에 맞는 요청이 들어왔다면 하위 컨트롤러의 공통 메서드 process 실행
v1 : 하위 컨트롤러가 서블릿에 종속적임. request, response, forward 관련 정보를 알아야 함
v2 : 포워딩(화면)을 view에 위임
  view의 리턴으로 포워딩 
v3 : 하위컨트롤러에서 서블릿 정보를 바로 받는 것이 아니라 프론트컨트롤러에서 관련 정보를 맵에 담아 줌