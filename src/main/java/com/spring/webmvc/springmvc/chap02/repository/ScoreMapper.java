package com.spring.webmvc.springmvc.chap02.repository;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// 학생들의 성적정보를 저장, 조회, 수정, 삭제하는 저장소 생성
@Mapper
public interface ScoreMapper {

    // 점수 저장
    boolean save(Score score);

    // 학생 정보 삭제
    boolean remove(int stuNum);

    // 학생 정보 수정
    boolean modify(Score score);

    // 전체 점수 정보 조회
    List<Score> findAll(String sort);

    // 개별 점수 정보 조회
    Score findOne(int stuNum);



}
