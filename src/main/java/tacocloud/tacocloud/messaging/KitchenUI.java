package tacocloud.tacocloud.messaging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import tacocloud.tacocloud.entity.Order;

@Component
@Slf4j
public class KitchenUI {

    public void displayOrder(Order order) {
        // TODO: тут должна быть логика
        log.info("RECEIVED ORDER: " + order);
    }
}
