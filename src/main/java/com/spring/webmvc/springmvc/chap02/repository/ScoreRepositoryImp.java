package com.spring.webmvc.springmvc.chap02.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // 스프링 빈 등록( == @Component) > 객체 생성을 스프링에 맡김
@RequiredArgsConstructor // 파이널 필드 초기화해주는 생성자 선언
public class ScoreRepositoryImp implements ScoreRepository {
    // 스프링 JDBC
    // 장점 : 중복 코드 줄일 수 있다
    // JDBC Template : JDBC를 단순화
    private final JdbcTemplate template;

/*  @RequiredArgsConstructor 가 대신 생성해 줌
    @Autowired
    public ScoreRepositoryImp(JdbcTemplate template) {
        this.template = template;
    }
*/

    @Override
    public boolean save(Score score) {
        String sql = "INSERT INTO tbl_score VALUES (seq_tbl_score.nextval, ?, ?, ?, ?, ?, ?, ?)";

        // insert, update, delete는 템플릿의 update() 메서드 사용
        // update - 생성된 행 개수 반환
        return template.update(sql, score.getName(), score.getKor(), score.getEng(), score.getMath(),
                score.getTotal(), score.getAverage(), score.getGrade().toString()) == 1;
    }

    @Override
    public List<Score> findAll(String sort) {
        StringBuilder sql = new StringBuilder("SELECT * FROM tbl_score ");
        // ?를 채우려고 하면 sort가 String이기 때문에 'sort' 이렇게 삽입됨
        switch (sort) {
            case "num":
                sql.append(" ORDER BY stu_num");
                break;
            case "name":
                sql.append(" ORDER BY stu_name");
                break;
            case "average":
                sql.append(" ORDER BY average DESC");
                break;
        }


        // SELECT문의 경우는 query()
        // 인수로는 sql문과 RowMapper<T>의 구현체를 넣어야 한다
//        return template.query(sql, new ScoreRowMapper());

/*        return template.query(sql, new RowMapper<Score>() {
            @Override
            public Score mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Score(rs);
            }
        });*/

        return template.query(sql.toString(), (rs, rowNum) -> new Score(rs));
    }

    @Override
    public Score findOne(int stuNum) {
        String sql = "select * from tbl_score where stu_num=?";
        // 단일 건수 조회시 사용
//        return template.queryForObject(sql, new ScoreRowMapper(), stuNum);
        return template.queryForObject(sql, (rs, rowNum) -> new Score(rs), stuNum);
    }

    @Override
    public boolean remove(int stuNum) {
        String sql = "delete from tbl_score where stu_num=?";
        return template.update(sql, stuNum) == 1;
    }

    }