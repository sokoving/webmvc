package com.spring.webmvc.springmvc.chap02.repository;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ScoreRowMapper implements RowMapper<Score> {
    // RowMapper는 @FunctionalInterface > 메서드 1개, 람다 사용 가능
    @Override
    public Score mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Score(rs);
    }
}
