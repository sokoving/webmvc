package com.spring.webmvc.springmvc.chap01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/model") // 공통 URL 처리 : @RequestMapping("/hobbies")는  /model/hobbies로 요청됨
public class ModelController {
    // 개별 URL 상수처리 (오타 검증, 유지보수용)
    private static class ModelUrl{
        public static final String HOBBIES = "/hobbies";
        public static final String HOBBIES2 = "/hobbies2";
        public static final String FORM = "/form";
        public static final String AGE_CHECK = "/age-check";
    }


    //=========================== JSP 파일로 포워딩할 때 데이터 전달하기 ===========================//

    // 방법 1 : Moodel 객체 사용하기
    @RequestMapping(ModelUrl.HOBBIES)
    public String hobbies(Model model){

        List<String> hList = new ArrayList<>();
        hList.add("산책");
        hList.add("뛰어놀기");
        hList.add("밥먹기");
        hList.add("낮잠자기");

        model.addAttribute("name", "멍멍이");
        model.addAttribute("hobbies", hList);

        // return "WEB-INF/views/chap01/hobbies.jsp 포워딩
        return "chap01/hobbies";
    }

    // 방법 2 : ModelAndView 사용하기
    @RequestMapping(ModelUrl.HOBBIES2)
    public ModelAndView hobbies2(){
        List<String> hList = new ArrayList<>();
        hList.add("산책2");
        hList.add("뛰어놀기2");
        hList.add("밥먹기2");
        hList.add("낮잠자기2");

        ModelAndView mv = new ModelAndView("chap01/hobbies");
        mv.addObject("name", "짹짹이");
        mv.addObject("hobbies", hList);

        return mv;
    }

    // age-form 띄우기
    @RequestMapping(ModelUrl.FORM)
    public String form(){
        return "chap01/age-form";
    }

/*    // age 데이터 처리
    @RequestMapping(ModelUrl.AGE_CHECK)
    public String check(@RequestParam("age") int age, Model model){
        // 나이로 출생년도 구해주기(한국나이)
        int birthYear = LocalDate.now().getYear() - age + 1;

        model.addAttribute("bYear", birthYear);
        model.addAttribute("age", age);

        return "chap01/age-result";
    }*/

    // 방법 3 @ModelAttribute 사용하기
    // age만 건네줄 거면 내부 코드 안 써도 됨
    @RequestMapping(ModelUrl.AGE_CHECK)
    public String check(@ModelAttribute("age") int age, Model model){
        System.out.println("@ModelAttribute 사용");
        // 나이로 출생년도 구해주기(한국나이) 
        int birthYear = LocalDate.now().getYear() - age + 1;

        model.addAttribute("bYear", birthYear);

        return "chap01/age-result";
    }

}
