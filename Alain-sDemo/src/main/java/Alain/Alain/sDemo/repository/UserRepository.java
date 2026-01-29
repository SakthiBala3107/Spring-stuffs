package Alain.Alain.sDemo.repository;

import Alain.Alain.sDemo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //    custom method to find use  via email
    Optional<User> findByEmail(String email);
}
