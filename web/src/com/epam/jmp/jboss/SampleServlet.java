package com.epam.jmp.jboss;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SampleServlet", urlPatterns = "/sample")
public class SampleServlet extends HttpServlet {

    @EJB
    private ServiceBean serviceBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("message", serviceBean.sayHello());
        request.getRequestDispatcher("hello.jsp").forward(request, response);
    }

}
