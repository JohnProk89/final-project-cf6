package gr.aueb.cf.finalprojectcf6.repository;

import gr.aueb.cf.finalprojectcf6.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameAndPassword(String username, String password);
}
