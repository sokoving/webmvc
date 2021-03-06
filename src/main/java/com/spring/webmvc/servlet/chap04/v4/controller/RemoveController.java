package com.spring.webmvc.servlet.chap04.v4.controller;

import com.spring.webmvc.servlet.chap04.Model;
import com.spring.webmvc.servlet.member.repository.MemoryMemberRepo;

import java.util.Map;

public class RemoveController implements ControllerV4 {
    @Override
    public String process(Map<String, String> paramMap, Model model) {

        // 삭제 처리
        MemoryMemberRepo repository = MemoryMemberRepo.getInstance();
        repository.remove(Integer.parseInt(paramMap.get("userNum")));

        // 회원목록으로 리다이렉트
        return "redirect:show";
    }
}
