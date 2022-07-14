package com.spring.webmvc.springmvc.chap02.repository;

import java.util.List;

// 학생들의 성적정보를 저장, 조회, 수정, 삭제하는 저장소 생성
public interface ScoreRepository {

    // 점수 저장
    boolean save(Score score);

    // 전체 점수 정보 조회
    List<Score> findAll(String sort);

    Score findOne(int stuNum);

    boolean remove(int stuNum);

}
