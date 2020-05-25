package TicketMania.Controllers;

import TicketMania.Entities.Ticket;
import TicketMania.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(path = "/api")
public class TicketController {

    @Autowired
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping(path = "/tickets")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Ticket> add(@RequestBody Ticket ticket) {
        try {
            ticketService.save(ticket);
            return new ResponseEntity<>(ticket, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

}
