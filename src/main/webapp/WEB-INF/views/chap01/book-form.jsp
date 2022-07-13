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

    <h1>책 주문하기</h1>
    <form action="#" method="get">
        <label>
            # 책 목록 <br>
            <select id="menu-sel" name="book-name">
                <option value="comic">만화책</option>
                <option value="novel">소설책</option>
                <option value="magazine">잡지</option>
            </select>
        </label>
        <label class="price">
            # 가격:
            <input id="price-tag" type="text" name="price" value="3000" readonly>
            원
        </label>
        <label>
            <button type="submit">주문하기</button>
        </label>
    </form>


    <script>
        const bookList = {
            comic: 3000,
            novel: 4000,
            magazine: 5000
        }

        const $sel = document.getElementById('menu-sel');
        $sel.onchange = e => {
            console.log(e.target);
            const price = bookList[e.target.value];
            console.log("price : " + price);
            const $priceTag = document.getElementById('price-tag');
            $priceTag.value = price;
        }



    </script>

</body>
</html>