# 마이바티스 라이브러리 빌드하기
1. 스프링 jdbc 빌드되어 있어야 함
2. build.gradle
   //마이바티스 라이브러리
   implementation "org.mybatis.spring.boot:mybatis-spring-boot-starter:2.1.0"

# jdbc 템플릿 단점
1. sql을 문자열로 쓰기 힘듦
2. 오타 생기기 쉬움
3. ? 채우기 까다로움
   4.. select 할 때 어려움

springmvc.chap04.mybatis.repository

# domain
```java
@Setter @Getter @ToString @NoArgsConstructor @AllArgsConstructor
public class Product {

    private String serialNo;
    private String productName;
    private int price;
    private Date madeAt;

```

# repository
```java
@Mapper // 마이바티스 동작 인터페이스 등록
public interface ProductMapper {
    boolean save(Product product);     // 제품 등록
    List<Product> findAll();    // 제품 전체 조회
    Product findOne(String serialNo);     // 제품 개별 조회
    boolean modify(Product product);    // 제품 수정
    boolean remove(String serialNo);    // 제품 삭제
```

# ProductMapper.xml
- 마이바티스가 파일을 만들어낼 때 도움을 주는 설정 파일
- interface ProductMapper와 똑같은 경로, 동일한 이름으로 resources에 xml 파일 만들기
- xml 파일의 독타입 선언
- sql 적을 때는 ; 안 씀
```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- mapper태그는 sql을 매핑할때 사용하는 태그
     namespace속성에는 사용할 인터페이스의 풀 패키지경로 + 인터페이스이름
  -->
<mapper namespace="com.spring.webmvc.springmvc.chap04.mybatis.repository.ProductMapper">

    <!-- 제품 등록 SQL 작성 :  id속성에는 추상메서드 이름  -->
    <insert id="save">
        INSERT INTO tbl_product
            (serial_no, product_name, price)
        VALUES (TO_CHAR(SYSDATE, 'YYYYMMDD')
        || LPAD(seq_product.nextval, 4, '0'),
        #{productName}, #{price})
    </insert>

</mapper>
```

