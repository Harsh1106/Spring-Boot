package com.Harsh;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/hello") it works only when we are using external tomcat
public class HelloServlet extends HttpServlet {
    //whenever we want this service to work we have to define a method which is called service.
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        //an imp method exectued when we send a request
        System.out.println("In service");
        res.setContentType("text/html"); //on writing this it will understand the difference between the text and the html
        PrintWriter out = res.getWriter();
        out.println("<h2><b>Hello World</b></h2>"); //this will write in the response object
    }
}
