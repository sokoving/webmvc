package com.spring.webmvc.springmvc.chap03;

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
@RequestMapping("/v2")
public class ScoreControllerV2 {

    // 의존관계 설정
    private final ScoreService service;

    // 점수 등록 후 조회 화면
    @RequestMapping("/score/list")
    public String list(
            // 파라미터가 없으면 num, 있으면 바뀜
            @RequestParam(defaultValue = "num") String sort,
            Model model){
        log.info("/score/list GET 요청!! - param1 : {}", sort);

        List<Score> scoreList = service.listService(sort);

        model.addAttribute("scores", scoreList);
        return "chap02/score-list";
    }

    // 점수 신규 등록
    @RequestMapping("/score/register")
    public String register(Score score){
        log.info("/score/register POST!! - " + score);

        return service.saveService(score) ? "redirect:/score/list" : "redirect:/";
    }

    // 점수 상세 조회
    @RequestMapping("/score/detail")
    public ModelAndView detail(int stuNum){
        log.info("/score/detail GET - " + stuNum);
        Score score = service.detailService(stuNum);
        ModelAndView mv = new ModelAndView("chap02/score-detail");
        mv.addObject("s", score);
        return mv;
    }

    // 점수 삭제
    @RequestMapping("/score/delete")
    public String delete(int stuNum){
        // 링크 요청은 get
        log.info("/score/delete GET - " + stuNum);
        return service.deleteService(stuNum)? "redirect:/score/list" : "redirect:/";
    }

}
