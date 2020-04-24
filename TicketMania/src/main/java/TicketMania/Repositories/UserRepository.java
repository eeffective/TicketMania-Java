package TicketMania.Repositories;

import TicketMania.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByFirstNameAndLastName(String firstName, String lastName);
}
