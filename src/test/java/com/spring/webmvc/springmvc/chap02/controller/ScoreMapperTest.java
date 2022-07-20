package com.spring.webmvc.springmvc.chap02.controller;

import com.spring.webmvc.springmvc.chap02.repository.Score;
import com.spring.webmvc.springmvc.chap02.repository.ScoreMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScoreMapperTest {

    @Autowired
    ScoreMapper mapper;

    @Test
    @DisplayName("DB에 새 학생 정보가 등록돼야 한다")
    void saveTest(){
        for (int i = 1; i < 10; i++) {
            Score score = new Score("학생" + i, i * 10 + i, i * 10 + i, i * 10 + i);
            System.out.println(score);
        }
    }

    @Test
    @DisplayName("DB에서 학생 정보가 수정돼야 한다")
    void modifyTest(){
        Score score = new Score();
        score.setStuNum(11);
        score.setName("매퍼수정");
        score.setKor(50);
        score.setAverage(50);
        score.setMath(50);
        score.setTotal(150);
        score.setAverage(50);

        boolean flag = mapper.modify(score);
        assertTrue(flag);
    }

    @Test
    @DisplayName("DB에서 학생 정보가 삭제돼야 한다")
    @Transactional
    @Rollback
    void removeTest(){
        int stuNum = 4;
        boolean flag = mapper.remove(stuNum);
        assertTrue(flag);
    }

    @Test
    @DisplayName("DB의 전체 학생 정보가 조회돼야 한다")
    void findAllTest(){
        for (Score score : mapper.findAll()) {
            System.out.println(score);
        }
    }

    @Test
    @DisplayName("DB에서 특정 학생의 정보가 조회돼야 한다")
    void findOneTest(){
        int stuNum = 9;
        Score one = mapper.findOne(stuNum);
        System.out.println(one);
        assertEquals(stuNum, one.getStuNum());
    }

}