<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div>
    <h2>게시물 작성</h2>

    <form>
        <div>
            <label for="title">제목</label>
            <input type="text"
                   id="title"
                   name="title"
                   placeholder="제목을 입력해주세요"
                   required>
        </div>

        <div>
            <label for="content">내용</label>
            <textarea id="content"
                      name="content"
                      placeholder="내용을 입력해주세요"
                      required></textarea>
        </div>

        <div>
            <button type="submit" class="submit-btn">게시물 등록</button>
            <button type="button" class="cancel-btn" onclick="history.back()">취소</button>
        </div>
    </form>
</div>