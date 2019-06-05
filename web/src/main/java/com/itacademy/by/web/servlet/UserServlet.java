package com.itacademy.by.web.servlet;

import com.itacademy.database.DAO.impl.UserSearchFilter;
import com.itacademy.database.entities.User;
import com.itacademy.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/user")
public class UserServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*UserSearchFilter searchFilter = UserSearchFilter.builder()
                .name("Alex")
                .login("Alex2002")
                .email("Alex2002@mail.ru")
                .phoneNumber("2002")
                .build();

                Это работает*/

        UserSearchFilter searchFilter = UserSearchFilter.builder()
                .limit(3)
                .offset(2)
                .build();

        List<User> users = userService.getWithFilters(searchFilter);
        req.setAttribute("users", users);

        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/user.jsp")
                .forward(req, resp);
    }
}
