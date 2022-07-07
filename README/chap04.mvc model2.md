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

## V2
- 컨트롤러간 공통 코드 리팩터링

## V3
- view 클래스에서 서블릿 요소 뻬내기