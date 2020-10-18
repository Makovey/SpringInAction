package tacocloud.tacocloud.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import tacocloud.tacocloud.entity.Order;

public class OrderListener {
    private KitchenUI ui;

    @Autowired
    public OrderListener(KitchenUI ui) {
        ui = ui;
    }

    @JmsListener(destination = "tacocloud.order.queue")
    public void receiveOrder(Order order) {
        ui.displayOrder(order);
    }
}
