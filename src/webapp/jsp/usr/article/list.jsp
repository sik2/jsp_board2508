<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- JSP 파일에서 JSTL을 사용하기 위해 taglib 선언-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>게시물 리스트</h1>

<div>
    <ul>
        <c:forEach var="article" items="${articleList}" varStatus="status">
            <li>${article.id}번 : ${article.title}</li>
        </c:forEach>
    </ul>
</div>