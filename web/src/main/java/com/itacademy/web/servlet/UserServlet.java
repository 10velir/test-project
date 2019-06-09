package com.itacademy.web.servlet;

import com.itacademy.database.fitler.UserSearchFilter;
import com.itacademy.database.entity.User;
import com.itacademy.service.service.UserService;
import com.itacademy.web.config.WebConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/user")
public class UserServlet extends HttpServlet {

    private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserSearchFilter searchFilter = UserSearchFilter.builder()
                .limit(3)
                .offset(2)
                .build();

        List<User> users = context.getBean(UserService.class).getWithFilters(searchFilter);
        req.setAttribute("users", users);

        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/user.jsp")
                .forward(req, resp);
    }
}
