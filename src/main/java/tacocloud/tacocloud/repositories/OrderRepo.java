package tacocloud.tacocloud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tacocloud.tacocloud.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {

}
