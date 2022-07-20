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

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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
- xml 파일의 독타입 선언과 포멧
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.spring.webmvc.springmvc.chap04.mybatis.repository.ProductMapper">

    <!-- 사용할 인터페이스의 SQL을 여기서 매핑한다   -->
    <insert id="save"> INSERT </insert>
    <delete id="remove"> DELETE </delete>
    <update id="modify"> UPDATE </update>

    <resultMap id="scoreMap" type="com.spring.webmvc.springmvc.chap02.repository.Score">
        <result property="stuNum" column="stu_num"/>
    </resultMap>

    <!--  동적 SQL 작성법 : 학생 전체 조회  -->
    <select id="findAll" resultMap="scoreMap">
        SELECT
        <if test="sort == 'name'">
            ORDER BY stu_name
        </if>
    </select>

    <!--  학생 개별 조회  -->
    <select id="findOne" resultMap="scoreMap">
        SELECT * FROM tbl_score
        WHERE stu_num = #{stuNum}
    </select>

</mapper>
```
- sql 적을 때는 ; 안 씀
- #{} 안에서 연산 안 됨, (#{} + 1) 이렇게 연산하기 

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.spring.webmvc.springmvc.chap04.mybatis.repository.ProductMapper">

    <!-- 사용할 인터페이스의 SQL을 여기서 매핑한다   -->
    <insert id="save">
        INSERT INTO tbl_score
        (stu_num, stu_name, kor, eng, math, total, average, grade)
        VALUES (seq_tbl_score.nextval, #{name}, #{kor}, #{eng}, #{math}, #{total}, #{average}, #{grade})
    </insert>

    <!-- 학생 정보 삭제 -->
    <delete id="remove">
        DELETE FROM tbl_score
        WHERE stu_num = #{stuNum}
    </delete>

    <!--  학생 정보 수정  -->
    <update id="modify">
        UPDATE tbl_score
        SET stu_name = #{name}, kor = #{kor}, eng = #{eng}, math=#{math}
        WHERE stu_num = #{stuNum}
    </update>

    <!--
        단일 컬럼이면 resultType 속성으로 데이터 타입 명시
            <select id="findAll" resultType="int">
                SELECT price FROM tbl_product
                ORDER BY price DESC
            </select>

        다중 컬럼 조회 시에는 resultMap 속성으로 데이터를 개체 처리
    -->
    <!--
        reultMap 설정  :  DB 컬럼과 자바 클래스 필드명의 차이를 지정
             DB 컬럼과 필드명이 완벽히 일치하면 설정하지 않아도 되지만
             자바에 스네이크 케이스를 쓰면 스프링에서 처리하다 오류가 날 수 있고
             DB에 캐멀 케이스를 쓰면 대소문자 구분이 되지 않기 때문에 ResultMap 설정을 해야 한다
                    모든 셀렉트에서 이 설정을 사용할 수 있다
    -->
    <resultMap id="scoreMap" type="com.spring.webmvc.springmvc.chap02.repository.Score">
        <!--   property 속성에는 자바 필드명, column에는 Db 컬럼명    -->
        <result property="name" column="stu_name"/>
        <result property="stuNum" column="stu_num"/>
    </resultMap>

    <!--  동적 SQL 작성법 : 학생 전체 조회  -->
    <select id="findAll" resultMap="scoreMap">
        SELECT * FROM tbl_score
        <if test="sort == 'num'">
            ORDER BY stu_num
        </if>
        <if test="sort == 'name'">
            ORDER BY stu_name
        </if>
        <if test="sort == 'average'">
            ORDER BY average DESC
        </if>
    </select>

    <!--  학생 개별 조회  -->
    <select id="findOne" resultMap="scoreMap">
        SELECT * FROM tbl_score
        WHERE stu_num = #{stuNum}
    </select>

</mapper>
```

- mapper 태그 : sql을 매핑할때 사용하는 태그

+ namespace 속성 : 사용할 인터페이스의 풀 패키지경로 + 인터페이스이름

- 동적 sql 작성법
- 참고 : https://mybatis.org/mybatis-3/ko/dynamic-sql.html
