package com.spring.webmvc.springmvc.chap03.bord.controller;

import com.spring.webmvc.springmvc.chap03.bord.repository.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Log4j2
public class BoardController {

    private final BoardService service;

    // Post 목록 불러오는 요청 처리
    @GetMapping("/board/list")
    public String list(Model model) {
        log.info("/board/list GET 요청!");
        List<Post> postList = service.listService();
        model.addAttribute("postList", postList);
        return "chap03/board-list";
    }

    // Post 상세 보기 요청
    @GetMapping("/board/content")
    public String detail(int boardNo, Model model) {
        log.info("/board/detail GET 요청!");
        Post post = service.detailService(boardNo);
        model.addAttribute("p", post);
        return "chap03/board-detail";
    }

    // 게시글 쓰기 화면요청
    @GetMapping("/board/write")
    public String write() {
        log.info("/board/write GET 요청!");
        return "chap03/board-write";
    }


    // 게시글 등록요청:
    @PostMapping("/board/write")
    public String write(String writer, String title, String content) {
        log.info("/board/write POST 요청! - {}, {}, {}", writer, title, content);
        Post newPost = new Post(writer, title, content);
        service.writeService(newPost);
        return "redirect:/board/list";

    }

    // 게시글 삭제요청
    @GetMapping("/board/delete")
    public String delete(int boardNo){
        boolean result = service.deleteService(boardNo);
        return "redirect:/board/list";
    }


    // 게시글 수정화면요청: /board/modify: GET
    // 게시글 수정요청: /board/modify: POST

}
