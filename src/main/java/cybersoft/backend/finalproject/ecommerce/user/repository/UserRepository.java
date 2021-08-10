package cybersoft.backend.finalproject.ecommerce.user.repository;

import cybersoft.backend.finalproject.ecommerce.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    int countByEmail(String username);

    int countByUsername(String username);

    int countByUserId(String userId);

}
