package com.example.demo.controller;

import PasswordHashing.HashPassword;
import model.User;
import service.UserService;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String page = request.getParameter("page");
        if (page.equalsIgnoreCase("register")) {
            User user = new User();

            user.setUserName(request.getParameter("userName"));
            user.setFullName(request.getParameter("fullName"));
            user.setPassword(request.getParameter("password"));
            user.setPassword(HashPassword.passwordHash(request.getParameter("password")));

            UserService userService = new UserService();
            //System.out.println(request.getParameter("password"));
            userService.insertUser(user);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);

        }
        if (page.equalsIgnoreCase("login")) {
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            password = HashPassword.passwordHash(password);

            User user = new UserService().getUser(userName, password);
            //user.setPassword(HashPassword.passwordHash(request.getParameter("password")));


            if (user != null) {

                HttpSession session = request.getSession();
                session.setAttribute("userName", userName);
                session.setAttribute("user", user);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Page/dashboard.jsp");
                requestDispatcher.forward(request, response);
            } else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
                requestDispatcher.include(request, response);
            }
        }

        if (page.equalsIgnoreCase("Logout")) {
            HttpSession session = request.getSession(false);
            session.invalidate();
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);

        }
        if (page.equalsIgnoreCase("userDetails")) {
            //  User user = new User();

            int id = Integer.parseInt(request.getParameter("id"));
            User user = new UserService().getUserRow(id);
            request.setAttribute("user", user);
            request.setAttribute("id", id);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Page/userDetails.jsp");
            requestDispatcher.forward(request, response);
        }

        if (page.equalsIgnoreCase("newUsers")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Page/register.jsp");
            requestDispatcher.forward(request, response);
        }

        if (page.equalsIgnoreCase("dashboard")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Page/dashboard.jsp");
            requestDispatcher.forward(request, response);
        }

        if (page.equalsIgnoreCase("user")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
        }
        if (page.equalsIgnoreCase("userDelete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            new UserService().deleteUser(id);
            try {
                List<User> arrayList = new UserService().getUserList();
                request.setAttribute("arrayList", arrayList);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Page/list_user.jsp");
            requestDispatcher.forward(request, response);
        }
        if (page.equalsIgnoreCase("userEdit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            User user = new UserService().getUserRow(id);
            request.setAttribute("id", id);
            request.setAttribute("user", user);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Page/update_user.jsp");
            requestDispatcher.forward(request, response);
        }
        if (page.equalsIgnoreCase("editUser")) {
            int id = Integer.parseInt((request.getParameter("id")));
            User user = new User();
            user.setUserName(request.getParameter("userName"));
            user.setFullName(request.getParameter("fullName"));
            user.setPassword(request.getParameter("password"));
            try {
                new UserService().updateUser(user, id);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try{
                List<User> arrayList = new UserService().getUserList();
                request.setAttribute("arrayList", arrayList);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Page/list_user.jsp");
            requestDispatcher.forward(request, response);

        }


        if (page.equalsIgnoreCase("userList")) {
            User user = new User();
            try {
                List<User> arrayList = new UserService().getUserList();
                request.setAttribute("arrayList", arrayList);
                request.setAttribute("user", user);

            } catch (SQLException e) {
                e.printStackTrace();
            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Page/list_user.jsp");
            requestDispatcher.forward(request, response);
        }


        // public void destroy() {
        //}
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        doPost(request, response);
    }
}

