package com.epam.jmp.jboss;

import com.epam.jmp.jboss.ejb.ServiceBean;
import com.epam.jmp.jboss.model.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "UsersServlet", urlPatterns = "/users")
public class UsersServlet extends HttpServlet {

    @EJB
    private ServiceBean serviceBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = request.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }
        final String json = sb.toString();
        // TODO: read user form json
        serviceBean.saveUser(new User("test", "Test"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String userId = request.getParameter("userId");
        request.setCharacterEncoding("utf8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        if ("users".equals(userId)) {
            final List<User> users = serviceBean.getUsers();
            out.print("[");
            for (int i = 0; i < users.size(); i++) {
                out.print(users.get(i));
                if (i < users.size() - 1) {
                    out.print(",");
                }
            }
            out.print("]");
        } else {
            out.print(serviceBean.getUser(userId));
        }
    }

}
