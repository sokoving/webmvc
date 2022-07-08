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

    <h1>${m.userNum}번 회원 상세 정보</h1>

    <ul>
        <li># 계정명: ${m.account}</li>
        <li># 비밀번호: ${m.password}</li>
        <li># 이름: ${m.userName}</li>
    </ul>
    <br>
    <a id="rm-btn" href="/mvc/v4/remove?userNum=${m.userNum}">[delete]</a>
    &nbsp;&nbsp;&nbsp;&nbsp;<a href="/mvc/v5/home">[Home]</a>
    &nbsp;<a href="/mvc/v5/show">[Member List]</a>
    


    <script>
        // 회원 삭제 확인 띄우기
        const $rmBtn = document.querySelector('#rm-btn');
        $rmBtn.addEventListener('click', e => {

            if (!confirm('진짜루 삭제???')) {
                // 링크 이동 중지
                e.preventDefault();
                // 삭제 취소
                return;
            }
            // 삭제 진행
        });
    </script>

</body>

</html>