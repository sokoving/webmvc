<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <!-- .jsp에서는 자바 코드를 쓸 수 있다 -->
    <!-- 자동으로 서블릿 클래스로 변환돼서 한줄마다 w.write()가 됨 -->
    <!-- 인텔리j 무료 버전은 vs코드로 html 써야 함 -->
    <!-- vs코드로 작성하고 저장하면 인텔리j로 가면 연동돼 있음ㅋㅋ -->

    <% for (int i = 0; i < 3; i++){ %>
    <h1>test.jsp입니다! 히히~</h1>
    <% } %>

    <%
        String[] arr = {"감자", "고구마", "당근"};
        for (String s : arr) {
    %>
        <h2> <%= s %> 캐러 가자! </h2>
    <% } %>

    
</body>
</html>