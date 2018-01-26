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
        String page = req.getParameter("page");
        String pagesize = req.getParameter("pagesize");
        String fromToday = req.getParameter("fromToday");
        String date = req.getParameter("date");
        String title = req.getParameter("title");

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter printWriter = null;

        DBGetter dbGetter = DBGetter.getInstance();
        ArrayList<java.util.HashMap<String, String>> data = dbGetter.getData(page,pagesize,fromToday,date,title);
        DataForm dataForm = new DataForm(data);

        try {
            printWriter = resp.getWriter();
            printWriter.println(dataForm.toXmlFormatString());
        } catch (IOException e) {
            e.printStackTrace();
        }


//        printWriter.println(page);
//        printWriter.println(pagesize);
//        printWriter.println(fromToday);
//        printWriter.println(date);
//        printWriter.println(title);
//        printWriter.println("<HTML><HEAD><TITLE>HelloServlet</TITLE></HEAD>");
//        printWriter.println("<BODY>");
//        printWriter.println("<H2> Clinet IP: " + req.getRemoteAddr() + "</H2>");
//        printWriter.println("<H2> Client Host : " + req.getRemoteHost() + "</H2>");
//        printWriter.println("<H2> Request URI : " + req.getRequestURI() + "</H2>");
//        printWriter.println("<H2> getPage : " + req.getParameter("page") + "</H2>");
//        printWriter.println("<H2> GET TEST</H2>");
//        printWriter.println("</BODY></HTML>");
    }



}
