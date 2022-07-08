<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>

<body>


    <h1>${name}의 취미 목록</h1>

    <ol>
        <!-- jstl 태그 밖에서는 html 주석 써도 됩니당 -->
        <%-- for(String h : hList) --%>
        <c:forEach var="h" items="${hobbies}">
            <%-- jstl 태그 안에서는 html 주석을 쓰면 안 됩니당 --%>
            <li>${h}</li>
        </c:forEach>

    </ol>
</body>

</html>