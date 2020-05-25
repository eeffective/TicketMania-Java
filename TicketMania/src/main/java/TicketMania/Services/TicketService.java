package TicketMania.Services;

import TicketMania.Entities.Ticket;
import TicketMania.Repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private final TicketRepository ticketRepo;

    public TicketService(TicketRepository ticketRepo) {
        this.ticketRepo = ticketRepo;
    }

    public Ticket findByType(String type) {
        return this.ticketRepo.findByType(type);
    }

    public void save(Ticket ticket){
        this.ticketRepo.save(ticket);
    }
}
