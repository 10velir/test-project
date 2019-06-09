package com.itacademy.web.servlet;

import com.itacademy.database.entity.Car;
import com.itacademy.database.fitler.CarSearchFilter;
import com.itacademy.service.service.CarService;
import com.itacademy.web.config.WebConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/cars")
public class CarServlet extends HttpServlet {

    private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CarSearchFilter searchFilter = CarSearchFilter.builder()
                .limit(8)
                .offset(2)
                .build();

        List<Car> cars = context.getBean(CarService.class).getWithFilters(searchFilter);

        req.setAttribute("cars", cars);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/car.jsp")
                .forward(req, resp);
    }
}
