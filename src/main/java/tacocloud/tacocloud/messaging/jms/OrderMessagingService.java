package tacocloud.tacocloud.messaging.jms;

import tacocloud.tacocloud.entity.Order;

public interface OrderMessagingService {
    void sendOrder(Order order);
}
