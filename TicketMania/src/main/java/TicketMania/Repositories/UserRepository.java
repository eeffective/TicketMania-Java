package TicketMania.Repositories;

import TicketMania.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
   // User findByEmail(String email);
    User findByFirstNameAndLastName(String firstName, String lastName);
    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);
}
