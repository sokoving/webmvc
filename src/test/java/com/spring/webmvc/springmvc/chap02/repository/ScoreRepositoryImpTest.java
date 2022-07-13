package com.spring.webmvc.springmvc.chap02.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 의존성 주입을 테스트 라인에서 사용 가ㅡㄴㅇ
class ScoreRepositoryImpTest {

    @Autowired
    ScoreRepository repository;

    @Test
    @DisplayName("회원 정보가 데이터베이스 테이블에 삽입되어야 한다. ")
    void saveTest(){
        Score e = new Score("eee", 60, 63, 65);
        boolean result = repository.save(e);
        assertTrue(result);
    }

    @Test
    @DisplayName("회원 정보가 데이터베이스 테이블에서 삭제되어야 한다. ")
    @Transactional  // 지워보고
    @Rollback       // 롤백시키기
    void removeTest(){
        // given
        int stuNum = 3;
        // when
        boolean result = repository.remove(stuNum);
        // then
        assertTrue(result);
    }

    @Test
    @DisplayName("전체 회원 정보가 데이터베이스 테이블에서 조회되어야 한다. ")
    @Transactional  // 지워보고
    @Rollback       // 롤백시키기
    void findAllTest(){
        System.out.println("findAllTest");
        List<Score> all = repository.findAll();
        for (Score score : all) {
            System.out.println(score);
        }
    }



    @Test
    @DisplayName("특정 학번에 대한 점수 정보를 조회해야 한다.")
    void findOneTest(){
        Score score = repository.findOne(5);
        System.out.println(score);
        assertEquals("ddd", score.getName());
    }

}