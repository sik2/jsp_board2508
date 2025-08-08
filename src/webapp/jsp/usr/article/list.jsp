<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="com.ll.jsp.board.boundedContext.article.dto.Article" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>



<h1>게시물 리스트</h1>

<div>
    <ul>
        <%
        List<Article> articleList = (List<Article>) request.getAttribute("articleList");
        for (int i = articleList.size() - 1; i >= 0; i--) {
        pageContext.setAttribute("article", articleList.get(i));
        %>
        <li>${article.id}번 : ${article.title}</li>
        <% } %>
    </ul>
</div>