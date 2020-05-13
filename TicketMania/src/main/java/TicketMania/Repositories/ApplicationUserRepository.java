package TicketMania.Repositories;

import TicketMania.Entities.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByEmail(String email);
    ApplicationUser findByFirstNameAndLastName(String firstName, String lastName);
}
