package tacocloud.tacocloud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tacocloud.tacocloud.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
