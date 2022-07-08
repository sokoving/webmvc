1. redirect : 재요청
``` 
resp.sendRedirect("/jsp/result.jsp");
    [client] -> [server] -> [client] -> [server]
           /work   redirect   /jsp/result.jsp
            /work 요청 정보(데이터)가 소멸됨
/work 요청 결과 : localhost:8181/jsp/result.jsp
                클라이언트가 주소창에 그대로 쳐도 접근 가능
```
 
2. forward
``` 
RequestDispatcher rd = req.getRequestDispatcher("/jsp/result.jsp");
rd.forward(req, resp);
    [client] -> [server] -> [/jsp/result.jsp]
           /work     forward   /jsp/result.jsp
             /work 요청 정보(데이터)가 유지됨
/work 요청 결과 : localhost:8181/work
```

# WEB-INF
- jsp 폴더 경로는 DB에 정보를 삽입할 수 있기 때문에 보안이 필요한 정보
- jsp 페이지의 외부 접근을 차단하고 서버에서만 접근할 수 있게 만드는 패키지
1. jsp 파일의 디렉토리 숨김
2. 서버에 직접 접근해 파라미터 조작하는 것을 막음
3. jsp 파일은 WEB-INF 패키지 안에 넣고
4. forwad

# 경로
 - /mvc/save  : 절대경로  > http://localhost:8181/mvc/save
 - save : 상대경로(./save) > http://localhost:8181/mvc/save