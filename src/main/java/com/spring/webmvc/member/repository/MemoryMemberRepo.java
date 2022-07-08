package com.spring.webmvc.member.repository;

import com.spring.webmvc.member.model.Member;

import java.util.*;

public class MemoryMemberRepo implements MemberRepository {

    // 회원 정보를 저장할 메모리 저장소
    private Map<Integer, Member> memberMap = new HashMap<>();

//     싱글톤 패턴 구현
    // 1. 생성자를 단 하나 선언하고 외부에서 객체 만들 수 없게 private로 제한
    private MemoryMemberRepo(){}
    // 2. 스스로의 객체를 단 하나 생성
    private static MemoryMemberRepo instance = new MemoryMemberRepo();

    // 3. 단 하나의 객체를 리턴하는 메서드를 만든다
    public static MemoryMemberRepo getInstance(){
        return instance;
    }

    // 멤버를 메모리에 저장(DB에 저장할 거면 DB연동한 애한테 위임하면 됨)
    @Override
    public void save(Member member) {
        memberMap.put(member.getUserNum(), member);
        System.out.println(memberMap);
    }

    @Override
    public List<Member> findAll() {
        List<Member> memberList = new ArrayList<>();
        for (Integer key : memberMap.keySet()) {
            memberList.add(memberMap.get(key));
        }
        return memberList;
    }

    @Override
    public Member findOne(int userNum) {
        return memberMap.get(userNum);
    }

    @Override
    public void remove(int userNum) {
        memberMap.remove(userNum);
    }
}
