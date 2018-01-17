/*
 * HelloServlet.java 2012. 9. 14.
 *
 * Copyright www.gurubee.net All rights Reserved.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet 간단 예제
 *
 * @author : oramaster
 *
 */
public class Test2 extends HttpServlet {

    // 대부분의 Servlet은 doGet 또는 doPost만 작성하며,
    // 컨테이너가 생성한 Request와 Response 객체를 전달 받는다.
    @Override
    public void init(){
        try {
            super.init();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");

        // Response 객체의 PrintWriter를 사용해 브라우저에 HTML을 출력한다.
        PrintWriter out = resp.getWriter();
        out.println("<HTML><HEAD><TITLE>HelloServlet</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<H2> Clinet IP: " + req.getRemoteAddr() + "</H2>");
        out.println("<H2> Client Host : " + req.getRemoteHost() + "</H2>");
        out.println("<H2> Request URI : " + req.getRequestURI() + "</H2>");
        out.println("</BODY></HTML>");
    }
}