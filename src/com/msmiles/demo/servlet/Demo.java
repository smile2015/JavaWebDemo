package com.msmiles.demo.servlet;

import com.msmiles.common.string.ChangeCharset;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Demo extends HttpServlet{
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ChangeCharset test = new ChangeCharset();
        //String str = "This is a 中文的 String!";
        //System.out.println("str: " + str);
        //String gbk = test.toGBK(str);

        String name = req.getParameter("name");
        String nameutf8 = test.toUTF_8(name);
        String namegbk = test.toGBK(nameutf8);
        System.out.println(namegbk);
        PrintWriter pw = resp.getWriter();
        String jsonStr="{\"value\":\"hello\"}";
        pw.println(jsonStr);
    }
}
