# 1. 스프링 jdbc 연결
## 1-1. build.gradle
- //spring jdbc 라이브러리
 + implementation "org.springframework.boot:spring-boot-starter-jdbc"

## 1-2. 데이터베이스 연결 정보 설정하기
- com.spring.webmvc.config.DataBaseConfig
```java
            @Configuration
            @ComponentScan(basePackages = "com.spring.webmvc")
            public class DataBaseConfig {
                // 접속정보 객체 빈 등록 (DataSource 객체)
                @Bean
                public DataSource dataSource() {
                    // 커넥션 풀: 데이터베이스 연결 객체를 모아둔 곳
                    HikariConfig config = new HikariConfig();
                    config.setUsername("spring4");
                    config.setPassword("1234");
                    config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
                    config.setDriverClassName("oracle.jdbc.driver.OracleDriver");
            
                    return new HikariDataSource(config);
            
                }
}
```



# 오라클 데이터베이스 연결 설정
## 1. WEB-INF.lib 패키지에 ojdbc6.jar 복붙
- webmvc/src/main/webapp/WEB-INF/lib/
- 오라클xe는 라이센스 만료로 직접 넣어야 함
- ojdbc6.jar 파일 경로
 + C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib
 
## 2. build.gradle
- 오라클 라이브러리 (11g edition - gradle, maven 라이센스 문제 공식 지원 불가)
 + implementation fileTree(dir: '/src/main/webapp/WEB-INF/lib', include: ['*.jar'])

## 3. 테스트
- com.spring.webmvc.DBConnectTest
```java

    private String uid = "hr";
    private String upw = "hr";
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String driver = "oracle.jdbc.driver.OracleDriver";

    @Test
    void connectTest() {

        try {
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, uid, upw);

            String sql = "SELECT first_name FROM employees";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("first_name"));
            }

        } catch (Exception e) {

        }
    }
```

