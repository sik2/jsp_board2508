package com.ll.jsp.board.boundedContext.global.base;

import com.ll.jsp.board.boundedContext.article.dto.Article;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class Rq {
    private final HttpServletRequest req;
    private final HttpServletResponse resp;

    public Rq(HttpServletRequest req, HttpServletResponse resp) {
        this.req = req;
        this.resp = resp;


        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 인코딩 설정에 실패했습니다.", e);
        }

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
    }

    public int getIntParam(String paramName, int defaultValue) {
        String value = getParam(paramName, "");

        if (value == null) {
            return defaultValue;
        }

        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public String getParam(String paramName, String defaultValue) {
        String value = req.getParameter(paramName);

        if (value == null) {
            return defaultValue;
        }

        return value;
    }

    public void appendBody(String str) {
        try {
            resp.getWriter().append(str);
        } catch (IOException e) {
            throw new RuntimeException("응답 작성 중 오류가 발생했습니다.", e);
        }
    }

    public void view(String path) {
        //"/jsp/usr/article/list.jsp" 이런형태로 만들어줌
       RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/" + path + ".jsp");

       try {
           requestDispatcher.forward(req, resp);
       } catch (ServletException e) {
           throw new RuntimeException("뷰로의 포워딩 중 오류가 발생했습니다.", e);
       } catch (IOException e) {
           throw new RuntimeException("뷰로의 포워딩 중 IO 오류가 발생했습니다.", e);
       }
    }

    public void getAttr(String name) {
        req.getAttribute(name);
    }

    public void setAttr(String name, Object value) {
        req.setAttribute(name, value);
    }

    public String getUrlPath() {
        return req.getRequestURI();
    }

    public String getMethod() {
        return req.getMethod();
    }
}
