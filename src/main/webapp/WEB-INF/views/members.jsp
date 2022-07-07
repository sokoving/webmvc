<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>

    <ul>
        <h1>MVC 버전 목록 보기</h1>
        <c:forEach var="m" items="${mList}">
            <li>
                <!-- {} 안에 m.멤머 클래스의 필드명(필드에 게터 없으면 오류) 혹은 getter를 쓴다 -->
                # 회원번호 : ${m.userNum} <mark>,</mark> 아이디: ${m.account} , 이름: ${m.userName}
            </li>
        </c:forEach>
    </ul>
    <a href="/mvc/join">새 회원 가입하기</a>
    

    <script></script>

</body>

</html>