package pl.filipwlodarczyk.Blog.engine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.filipwlodarczyk.Blog.engine.models.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> selectApplicationUserByUsername(String username);
}
