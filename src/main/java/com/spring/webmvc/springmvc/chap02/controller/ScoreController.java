package com.spring.webmvc.springmvc.chap02.controller;

import com.spring.webmvc.springmvc.chap02.repository.Score;
import com.spring.webmvc.springmvc.chap02.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor     // 의존관계 주입
public class ScoreController {

    // 의존관계 설정
    private final ScoreRepository repository;

    // 점수 등록 후 조회 화면
    @RequestMapping("/score/list")
    public String list(
            // 파라미터가 없으면 num, 있으면 바뀜
            @RequestParam(defaultValue = "num") String sort,
            Model model){
        log.info("/score/list GET 요청!! - param1 : {}", sort);

        // jsp에 점수 정보 리스트 전달
        List<Score> scoreList = repository.findAll(sort);

        // 이름 마킹 처리
        for (Score s : scoreList) {
            String original = s.getName();
            StringBuilder markName = new StringBuilder(String.valueOf(original.charAt(0)));
            for (int i = 0; i < original.length()-1; i++) {
                markName.append("*");
            }
            s.setName(markName.toString());
        }

        model.addAttribute("scores", scoreList);
        return "chap02/score-list";
    }

    // 점수 신규 등록
    @RequestMapping("/score/register")
    public String register(Score score){
        // 스프링이 기본생성자 호출 뒤, 세터로 이름, 국, 영, 수 세팅
        // 후처리를 해야 모든 값이 세팅됨
        score.calcTotalAndAvg();
        score.calcGrade();

        log.info("/score/register POST!! - " + score);

        // 포워드 chap02/score-list 하면 scoreList가 들어가지 않음 > 리다이렉트
        return repository.save(score) ? "redirect:/score/list" : "redirect:/";
    }

    // 점수 상세 조회
    @RequestMapping("/score/detail")
    public ModelAndView detail(int stuNum){
        log.info("/score/detail GET - " + stuNum);
        Score score = repository.findOne(stuNum);
        ModelAndView mv = new ModelAndView("chap02/score-detail");
        mv.addObject("s", score);
        return mv;
    }

    // 점수 삭제
    @RequestMapping("/score/delete")
    public String delete(int stuNum){
        // 링크 요청은 get
        log.info("/score/delete GET - " + stuNum);
        return repository.remove(stuNum)? "redirect:/score/list" : "redirect:/";
    }

}
