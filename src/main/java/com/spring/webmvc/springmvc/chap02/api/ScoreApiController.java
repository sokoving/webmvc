package com.spring.webmvc.springmvc.chap02.api;

import com.spring.webmvc.springmvc.chap02.repository.Score;
import com.spring.webmvc.springmvc.chap02.repository.ScoreMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/score")
@Log4j2
@CrossOrigin
public class ScoreApiController {

    private final ScoreMapper mapper;

        /*
        - 점수 목록 조회요청 : /api/v1/score - GET
        - 점수 개별 조회요청 : /api/v1/score/1 - GET
        - 점수 쓰기 요청 : /api/v1/score - POST
        - 점수 수정 요청 : /api/v1/score/1 - PUT
        - 점수 삭제 요청 : /api/v1/score/1 - DELETE
     */

    // - 점수 목록 조회요청 : /api/v1/score - GET
    @GetMapping("")
    public List<Score> list(@RequestParam(defaultValue = "num") String sort){
        log.info("/api/v1/score GET!! - {}", sort);
        List<Score> scoreList = mapper.findAll(sort);
        return scoreList;
    }

//        - 점수 개별 조회요청 : /api/v1/score/1 - GET
    @GetMapping("/{stuNum}")
    public Score oneList(@PathVariable int stuNum){
        log.info("/api/v1/score/{} GET!!", stuNum);
        return mapper.findOne(stuNum);
    }

//        - 점수 쓰기 요청 : /api/v1/score - POST
    @PostMapping("")
    public void save(@RequestBody Score score){
        score.calcTotalAndAvg();
        score.calcGrade();
        log.info("/api/v1/score/ POST!! - {}", score);
        mapper.save(score);
    }

//        - 점수 수정 요청 : /api/v1/score/1 - PUT
    @PostMapping("/{stuNum}")
    public void modify(@PathVariable int stuNum, @RequestBody Score score){
        score.setStuNum(stuNum);
        log.info("/api/v1/score/{} PUT!! - {}", stuNum, score);
        mapper.modify(score);
    }


//        - 점수 삭제 요청 : /api/v1/score/1 - DELETE
    @DeleteMapping("/{stuNum}")
    public void delete(@PathVariable int stuNum){
        log.info("/api/v1/score/{} DELETE!! - {}", stuNum);
        mapper.remove(stuNum);
    }

}
