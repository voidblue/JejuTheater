package Servlet;

import DataBase.DBGetter;
import DataBase.DataForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Servlet extends HttpServlet {
    @Override
    public void init() {
        try {
            super.init();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp){
        int page = Integer.parseInt(req.getParameter("page"));
        int pagesize = Integer.parseInt(req.getParameter("pagesize"));
        int formToday = Integer.parseInt(req.getParameter("fromToday"));
        String date = req.getParameter("date");
        String title = req.getParameter("title");


        resp.setContentType("text/xml; charset=UTF-8");
        PrintWriter printWriter = null;

        try {
            printWriter = resp.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DBGetter dbGetter = DBGetter.getInstance();
        ArrayList data = dbGetter.getData(page,pagesize,formToday,date,title);
        DataForm dataForm = new DataForm(data);


        printWriter.print(dataForm.toXml());
//        printWriter.println("<HTML><HEAD><TITLE>HelloServlet</TITLE></HEAD>");
//        printWriter.println("<BODY>");
//        printWriter.println("<H2> Clinet IP: " + req.getRemoteAddr() + "</H2>");
//        printWriter.println("<H2> Client Host : " + req.getRemoteHost() + "</H2>");
//        printWriter.println("<H2> Request URI : " + req.getRequestURI() + "</H2>");
//        printWriter.println("<H2> getPage : " + req.getParameter("page") + "</H2>");
//        printWriter.println("<H2> GET TEST</H2>");
//        printWriter.println("</BODY></HTML>");
    }

    public static void main(String args[]){
        DBGetter dbGetter = DBGetter.getInstance();
        ArrayList xxx = dbGetter.getData(1,450, 1, null, null);
        System.out.println(xxx.toString().replace("}", "}\n"));

        DataForm dataForm = new DataForm(xxx);
        dataForm.toXml();

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
