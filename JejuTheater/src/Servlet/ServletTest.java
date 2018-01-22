package Servlet;
/*
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletTest extends HttpServlet {
    @Override
    public void init() {
        try {
            super.init();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp){
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter printWriter = null;

        try {
            printWriter = resp.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }


        printWriter.println("<HTML><HEAD><TITLE>HelloServlet</TITLE></HEAD>");
        printWriter.println("<BODY>");
        printWriter.println("<H2> Clinet IP: " + req.getRemoteAddr() + "</H2>");
        printWriter.println("<H2> Client Host : " + req.getRemoteHost() + "</H2>");
        printWriter.println("<H2> Request URI : " + req.getRequestURI() + "</H2>");
        printWriter.println("<H2> GET TEST</H2>");
        printWriter.println("</BODY></HTML>");
    }

//    public void doPost(HttpServletRequest req, HttpServletResponse resp){
//        resp.setContentType("text/html; charset=UTF-8");
//        PrintWriter printWriter = null;
//
//        try {
//            printWriter = resp.getWriter();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        printWriter.println("<HTML><HEAD><TITLE>HelloServlet</TITLE></HEAD>");
//        printWriter.println("<BODY>");
//        printWriter.println("<H2> Clinet IP: " + req.getRemoteAddr() + "</H2>");
//        printWriter.println("<H2> Client Host : " + req.getRemoteHost() + "</H2>");
//        printWriter.println("<H2> Request URI : " + req.getRequestURI() + "</H2>");
//        printWriter.println("<H2> POST TEST</H2>");
//        printWriter.println("</BODY></HTML>");
//    }

//    public void service(HttpServletRequest request, HttpServletResponse response){
//        getServletContext().log("service() called");
////        doGet(request, response);
//    }
}
*/