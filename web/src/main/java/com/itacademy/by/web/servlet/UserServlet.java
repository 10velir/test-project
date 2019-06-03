package com.itacademy.by.web.servlet;

import com.itacademy.database.entities.Car;
import com.itacademy.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/car")
public class UserServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();

   /* @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Car car = userService.getWithFilters("model", "GGG");

               req.setAttribute("car", car);

        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/user.jsp")
                .forward(req,resp);


    }*/

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Car car = userService.getByModel("TT");
        req.setAttribute("car", car);

        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/user.jsp")
                .forward(req,resp);
    }
}
