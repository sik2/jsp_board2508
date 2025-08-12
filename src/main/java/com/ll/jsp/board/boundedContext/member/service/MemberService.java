package com.ll.jsp.board.boundedContext.member.service;

import com.ll.jsp.board.boundedContext.base.Container;
import com.ll.jsp.board.boundedContext.member.repository.MemberRepository;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService() {
        this.memberRepository = Container.memberRepository;
    }

    public void join(String username, String password, String name) {
        memberRepository.save(username, password, name);
    }
}
