package TicketMania.Controllers;

import TicketMania.Entities.MusicEvent;
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

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(path = "/tickets")
    public ResponseEntity<Ticket> add(@RequestBody Ticket ticket) {
        try {
            ticketService.save(ticket);
            return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(path = "/{id}")
    public ResponseEntity<Ticket> update(@RequestBody Ticket newTicket, @PathVariable Long id) {
        return ticketService.findById(id)
                .map(ticket -> {
                    ticket = newTicket;
                    ticketService.save(ticket);
                    return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
                })
                .orElseGet(() -> {
                    newTicket.setId(id);
                    ticketService.save(newTicket);
                    return new ResponseEntity<>(newTicket, HttpStatus.ACCEPTED);
                });
    }
}
