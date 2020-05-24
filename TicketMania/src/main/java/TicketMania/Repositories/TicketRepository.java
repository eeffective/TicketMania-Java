package TicketMania.Repositories;

import TicketMania.Entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Ticket findByType(String type);
}
