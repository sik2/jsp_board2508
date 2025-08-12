package com.ll.jsp.board.boundedContext.member.controller;


import com.ll.jsp.board.boundedContext.base.Container;
import com.ll.jsp.board.boundedContext.global.base.Rq;
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
        String password = rq.getParam("password", "");
        String name = rq.getParam("name", "");

        memberService.join(username, password, name);

        rq.replace("%s 님 회원가입이 완료 되었습니다.".formatted(username), "/");
    }
}
