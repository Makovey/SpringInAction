package tacocloud.tacocloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import tacocloud.tacocloud.entity.Order;
import tacocloud.tacocloud.entity.User;
import tacocloud.tacocloud.repositories.OrderRepo;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

    private final OrderRepo orderRepo;

    @Autowired
    public OrderController(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping("/current")
    public String orderForm(Model model,
                            @AuthenticationPrincipal User user,
                            @ModelAttribute Order order) {

        if (order.getName() == null) {
            order.setName(user.getFullName());
        }
        if (order.getStreet() == null) {
            order.setStreet(user.getStreet());
        }
        if (order.getCity() == null) {
            order.setCity(user.getCity());
        }
        if (order.getState() == null) {
            order.setState(user.getState());
        }
        if (order.getZip() == null) {
            order.setZip(user.getZip());
        }
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors errors,
                               SessionStatus sessionStatus,
                               @AuthenticationPrincipal User user) {
        if (errors.hasErrors()) {
            return "orderForm";
        }

        order.setUser(user);

        orderRepo.save(order);
        sessionStatus.setComplete();
        log.info("Order submitted" + order);

        return "redirect:/";
    }
}
