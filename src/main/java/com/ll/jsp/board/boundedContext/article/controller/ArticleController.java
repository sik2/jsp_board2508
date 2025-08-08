package com.ll.jsp.board.boundedContext.article.controller;


import com.ll.jsp.board.boundedContext.article.dto.Article;
import com.ll.jsp.board.boundedContext.global.base.Rq;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class ArticleController {
    private List<Article> articleList;

    public ArticleController() {
        articleList = new ArrayList<>();
        makeTestData();
    }

    void makeTestData() {
        LongStream.rangeClosed(1, 5).forEach(i -> {
            Article article = new Article(i, "제목 " + i, "내용 " + i);
            articleList.add(article);
        });
    }

    public void showList(Rq rq) {
//        List<Article> articleList = this.articleList;
//        Collections.reverse(articleList);
        List<Article> articleList = this.articleList.stream()
                .sorted(Comparator.comparing(Article::getId).reversed()) // 정렬 기준 예시
                .toList();

        rq.setAttr("articleList", articleList);

        rq.view("usr/article/list");
    }

    public void showWrite(Rq rq) {

        rq.view("usr/article/write");
    }

    public void doWrite(Rq rq) {
        rq.appendBody("글 작성 완료");
    }
}
