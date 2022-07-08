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

    <h1>로그인 검증 페이지입니다.</h1>

    <c:choose>
        <c:when test="${idFlag}">
            <c:choose>
                <c:when test="${pwdFlag}">
                    <h2>로그인에 성공했습니다.</h2>
                </c:when>

                <c:otherwise>
                    <h2>비밀번호가 틀렸습니다.</h2>
                </c:otherwise>
            </c:choose>
        </c:when>

        <c:otherwise>
            <h2>아이디가 틀렸습니다.</h2>
        </c:otherwise>
    </c:choose>


</body>

</html>