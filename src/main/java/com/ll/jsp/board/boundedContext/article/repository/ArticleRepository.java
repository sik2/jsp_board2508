package com.ll.jsp.board.boundedContext.article.repository;

import com.ll.jsp.board.boundedContext.article.dto.Article;
import com.ll.jsp.board.boundedContext.base.Container;
import com.ll.jsp.board.db.DBConnection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArticleRepository {
    private List<Article> articleList;
    DBConnection dbConnection;

    public ArticleRepository() {
        articleList = new ArrayList<>();
        dbConnection = Container.dbconnection;
    }

    public List<Article> findAll() {
        return articleList.stream()
                .sorted(Comparator.comparing(Article::getId).reversed()) // 정렬 기준 예시
                .toList();
    }

    public long save(String title, String content) {
        int id = dbConnection.insert("INSERT INTO article SET title='%s', content='%s'".formatted(title, content));

        return id;
    }

    public Article findById(long id) {
        return articleList.stream()
                .filter(article -> article.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void modify(long id, String title, String content) {
        Article article = findById(id);

        if (article == null) return;

        article.setTitle(title);
        article.setContent(content);
    }

    public void delete(long id) {
        Article article = findById(id);

        if (article == null) return;

        articleList.remove(article);
    }
}
