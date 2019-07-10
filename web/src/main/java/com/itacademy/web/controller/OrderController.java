package com.itacademy.web.controller;

import com.itacademy.database.entity.ClientOrder;
import com.itacademy.database.entity.User;
import com.itacademy.service.dto.LeaseTImeDto;
import com.itacademy.service.dto.OrderDto;
import com.itacademy.service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Optional;

import static com.itacademy.web.urlpath.UrlPath.ADMIN_ORDERS;
import static com.itacademy.web.urlpath.UrlPath.API;
import static com.itacademy.web.urlpath.UrlPath.CREATE;
import static com.itacademy.web.urlpath.UrlPath.DECISION;
import static com.itacademy.web.urlpath.UrlPath.ORDER;
import static com.itacademy.web.urlpath.UrlPath.SAVE_DECISION;

@Controller
@RequestMapping(API + ORDER)
@SessionAttributes({"currentUser", "currentOrder"})
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public String getPage(Model model, @ModelAttribute("currentUser") User user) {
        model.addAttribute("orders", orderService.getAll());
        model.addAttribute("currentUser");

        return "order";
    }

    @PostMapping
    public String getPageByPost(Model model) {
        model.addAttribute("orders", orderService.getAll());

        return "order";
    }

    @GetMapping("ByUserId")
    public String getPageById(Model model, @ModelAttribute("currentUser") User user) {
        model.addAttribute("orders", orderService.getByUserId(user.getId()));

        return "order";
    }

    @PostMapping("ByUserId")
    public String getPageByPost(Model model, @ModelAttribute("currentUser") User user) {
        model.addAttribute("orders", orderService.getByUserId(user.getId()));

        return "order";
    }

    @PostMapping(CREATE)
    public String createOrder(Model model, OrderDto dto, LeaseTImeDto tImeDto, @ModelAttribute("currentUser") User user) {
        dto.setUserId(user.getId());
        orderService.createOrder(dto, tImeDto);
        model.addAttribute("orders", orderService.getAll());

        return "redirect:/api/order/ByUserId";
    }

    @PostMapping(ADMIN_ORDERS)
    public String getAdminOrders(Model model) {
        model.addAttribute("orders", orderService.getAll());

        return "adminOrders";
    }

    @GetMapping(ADMIN_ORDERS)
    public String getAdminOrdersByGet(Model model) {
        model.addAttribute("orders", orderService.getAll());

        return "adminOrders";
    }

    @PostMapping(DECISION)
    public String makeAnswer(Model model, Long orderId) {
        Optional<ClientOrder> order = orderService.getById(orderId);
        order.ifPresent(clientOrder -> model.addAttribute("currentOrder", clientOrder));

        return "decision";
    }


    @PostMapping(SAVE_DECISION)
    public String saveDecision(Model model, String notes, Boolean decision, @ModelAttribute("currentOrder") ClientOrder order) {
        order.setAdminApproval(decision);
        order.setNotes(notes);
        ClientOrder clientOrder = orderService.save(order);
        model.addAttribute("currentOrder", clientOrder);

        return "decision";
    }
}
