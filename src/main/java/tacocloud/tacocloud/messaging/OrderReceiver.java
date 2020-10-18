package tacocloud.tacocloud.messaging;

import tacocloud.tacocloud.entity.Order;

public interface OrderReceiver {

    Order receiveOrder();
}
