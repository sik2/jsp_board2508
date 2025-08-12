package com.ll.jsp.board.boundedContext.member.repository;

import com.ll.jsp.board.boundedContext.member.dto.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    private List<Member>  memberList;
    private long lastId;

    public MemberRepository() {
        memberList = new ArrayList<>();
        lastId = 0;
    }

    public void save(String username, String password, String name) {
        long id = ++lastId;

        Member member = new Member(id, username, password, name);

        memberList.add(member);
    }
}
