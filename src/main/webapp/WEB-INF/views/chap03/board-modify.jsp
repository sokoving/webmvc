<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <style>
        label {
            display: block;
        }

        textarea {
            display: block;
            padding: 5px;
        }

        .content-wrap {
            margin: 10px 0;
        }
    </style>

</head>

<body>

    <h1>${p.boardNo}번 게시글 수정</h1>
    <form action="/board/modify" method="post">
        <input type="text" name="boardNo" value="${p.boardNo}" hidden>
        <label>
            # 작성자 : <input type="text" name="writer" value="${p.writer}">
        </label>
        <label>
            # 글 제목 : <input type="text" name="title" value="${p.title}">
        </label>
        <label class="content-wrap">
            # 글 내용
            <textarea name="content" cols="40" rows="10">${p.content}</textarea>
        </label>

        <div id="btn-wrap">
            <button type="submit" id="modi-btn">수정</button>
            <button type="button" id="list-btn">취소</button>
        </div>
    </form>

    <script>
        const $btn = document.getElementById('btn-wrap');
        $btn.addEventListener('click', e => {
            if (!e.target.matches('button')){
                return;
            } 
            // 수정하기
            else if (e.target.matches('#modi-btn')){
                const $wInput = document.getElementById('wInput');
                const $tInput = document.getElementById('tInput');
                const $cArea = document.getElementById('cArea');
                
                $wInput.setAttribute('value', $wInput.value);
                $tInput.setAttribute('value', $tInput.value);
                $cArea.setAttribute('value', value);
            }
            // 수정 취소
            else if (e.target.matches('#list-btn')) {
                location.href = "/board/list";
            } 
        });
    </script>
</body>

</html>