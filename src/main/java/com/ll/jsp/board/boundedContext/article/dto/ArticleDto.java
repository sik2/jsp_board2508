package com.ll.jsp.board.boundedContext.article.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ArticleDto {
    private long id;
    private String title;
    private String content;
    private String author;
    private String regDate;
}

