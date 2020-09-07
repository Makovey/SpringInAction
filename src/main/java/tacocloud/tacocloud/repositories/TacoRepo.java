package tacocloud.tacocloud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tacocloud.tacocloud.entity.Taco;

public interface TacoRepo extends JpaRepository<Taco, Long> {

}
