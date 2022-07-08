package com.spring.webmvc.servlet.member.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 회원 정보를 담을 인스턴스 생성용 클래스
@Setter @Getter @ToString
public class Member {

    private static int sequence; // 회원 일련번호 DB의 시퀀스와 비슷한 역할

    private int userNum; // 일련번호를 저장
    private String account;
    private String password;
    private String userName;

    public Member() {
        this.userNum = ++sequence;
    }

    public Member(String account, String password, String userName) {
        this();
        this.account = account;
        this.password = password;
        this.userName = userName;
    }
}
