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

    <h1>로그인 페이지입니다</h1>
    <form action="/hw/s-login-check" method="post">

        <label>
            # 아이디 :
            <input type="text" name="id">
        </label>
        <label>
            <br>
            # 비밀번호 : 
            <input type="password" name="pwd">
        </label>
        <br>
        <button type="submit">로그인</button>


    </form>

</body>

</html>