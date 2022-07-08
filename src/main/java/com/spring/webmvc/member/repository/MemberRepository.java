package com.spring.webmvc.member.repository;

import com.spring.webmvc.member.model.Member;

import java.util.List;

// 멤버 저장 인터페이스
public interface MemberRepository {
    // 회원 가입 기능
    void save(Member member);

    // 전체 회원 조회 기능
    List<Member> findAll();

    Member findOne(int userNum);
}
