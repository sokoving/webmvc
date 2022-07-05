# mvc 시작하기
1. spring initializr
- Gradle Project
- Java
- 2.7.1
- com.spring
- webmvc
- Jar
- 11
- Lombok
- *Spring Web*

2. main.resources.application.properties
> server.port = 8181
- 기본값 포트 8080은 오라클이 가지고 있기 때문에
- 톰캣 포트를 8181로 변경

3. WebmvcApplication
> main.java.com.spring.webmvc.WebmvcApplication
- 실행시키기
- 무한루프로 실행되면 서버 정상 작동 중

4. 브라우저에서 접속
- http://localhost:8181/
- cmp  > ipconfig > IPv4 주소 : 포트번호
  + http://192.168.25.92:8181/
- http://127.0.0.1:8181/