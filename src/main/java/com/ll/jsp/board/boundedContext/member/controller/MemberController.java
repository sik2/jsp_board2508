package com.ll.jsp.board.boundedContext.member.controller;


import com.ll.jsp.board.boundedContext.base.Container;
import com.ll.jsp.board.boundedContext.global.base.Rq;
import com.ll.jsp.board.boundedContext.member.dto.Member;
import com.ll.jsp.board.boundedContext.member.service.MemberService;

public class MemberController {

    private final MemberService memberService;

    public MemberController () {
        memberService = Container.memberService;
    }

    public void showJoin(Rq rq) {
        rq.view("usr/member/join");
    }

    public void doJoin(Rq rq) {
        String username = rq.getParam("username", "");

        if (username.trim().isBlank()) {
            rq.replace("로그인 아이디를 입력해주세요.", "/usr/member/join");
            return;
        }

        String password = rq.getParam("password", "");

        if (password.trim().isBlank()) {
            rq.replace("비밀번호를 입력해주세요.", "/usr/member/join");
            return;
        }

        String name = rq.getParam("name", "");

        if (name.trim().isBlank()) {
            rq.replace("이름을 입력해주세요.", "/usr/member/join");
            return;
        }

        Member member = memberService.findByUsername(username);

        if (member != null) {
            rq.replace("이미 가입된 회원입니다.",  "/usr/member/join");
            return;
        }

        memberService.join(username, password, name);

        rq.replace("%s 님 회원가입이 완료 되었습니다.".formatted(username), "/");
    }

    public void showLogin(Rq rq) {
        rq.view("usr/member/login");
    }
}
