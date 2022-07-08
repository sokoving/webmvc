# 99년도 버전 jsp 해보기
1. build.gradle에 jsp 라이브러리 추가
```
   implementation 'javax.servlet:jstl'
   implementation 'org.apache.tomcat.embed:tomcat-embed-jasper'
```
2. src.main.webapp에 jsp 파일 생성하기
- jsp의 패키지는 webapp 고정
- jsp에는 html과 java를 동시에 쓸 수 있다

3. jsp에 코드 쓰기
- 맨 윗줄에는 <%@ page contentType="text/html; charset=UTF-8" language="java" %> 이 코드 쓰기
- vs코드로 가서 html은 html 문법 그대로 작성하기(인텔리제이 얼티밋에서는 html 지원)
- 자바 코드는 디렉티드 문법 <% %>로 감싸기

## jsp가 서블릿을 완전 대체햇었음
- 