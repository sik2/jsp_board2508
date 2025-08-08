package com.ll.jsp.board.boundedContext.article.controller;


import com.ll.jsp.board.boundedContext.global.base.Rq;

public class ArticleController {
    public void showList(Rq rq) {
        rq.view("usr/article/list");
    }

}
