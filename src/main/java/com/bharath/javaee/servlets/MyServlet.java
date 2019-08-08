package com.bharath.javaee.servlets;
import com.bharath.javaee.jms.MyMessageProducer;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class MyServlet extends HttpServlet {

    private static final long serialVersionUID = -8931817736225798566L;

    @EJB
    MyMessageProducer producer;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = "Hello Message from JavaEE Server using JMS!!";
        producer.sendMessage(message);
        resp.getWriter().write("published the message" + message);
    }
}
