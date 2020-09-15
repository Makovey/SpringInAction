package tacocloud.tacocloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tacocloud.tacocloud.entity.Order;
import tacocloud.tacocloud.repositories.OrderRepo;

@RestController
@RequestMapping(path = "/orders", produces = "application/json")
@CrossOrigin(origins = "*")
public class OrderRestController {

    private OrderRepo orderRepo;

    @Autowired
    public OrderRestController(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @PutMapping(path = "/{orderId}", consumes = "application/json")
    public Order putOrder(@RequestBody Order order) {
        return orderRepo.save(order);
    }

    @PatchMapping(path = "/{orderId}", consumes = "application/json")
    public Order patchOrder(@PathVariable("orderId") Long id, @RequestBody Order patch) {
        Order currentOrder = orderRepo.findById(id).get();
        if (patch.getName() != null) {
            currentOrder.setName(patch.getName());
        }
        if (patch.getStreet() != null) {
            currentOrder.setStreet(patch.getStreet());
        }
        if (patch.getState() != null) {
            currentOrder.setState(patch.getState());
        }
        if (patch.getCity() != null) {
            currentOrder.setCity(patch.getCity());
        }
        if (patch.getZip() != null) {
            currentOrder.setZip(patch.getZip());
        }
        if (patch.getCcNumber() != null) {
            currentOrder.setCcNumber(patch.getCcNumber());
        }
        if (patch.getCcExpiration() != null) {
            currentOrder.setCcExpiration(patch.getCcExpiration());
        }
        if (patch.getCcCVV() != null) {
            currentOrder.setCcCVV(patch.getCcCVV());
        }
        return orderRepo.save(currentOrder);
    }

    @DeleteMapping(path = "/{orderId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("orderId") Long id){
        orderRepo.deleteById(id);
    }
}
