package com.spring.webmvc.member.repository;

import com.spring.webmvc.member.model.Member;

import java.util.List;

// 멤버 저장 인터페이스
public interface MemberRepository {
    // 회원 가입 기능
    void save(Member member);

    // 전체 회원 조회 기능
    List<Member> findAll();

    // 특정 회원 조회 기능
    Member findOne(int userNum);

    // 특정 회원 삭제 기능
    void remove(int userNum);
}
