package gr.aueb.cf.finalprojectcf6.repository;

import gr.aueb.cf.finalprojectcf6.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameAndPassword(String username, String password);
}
