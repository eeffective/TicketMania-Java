package TicketMania.Controllers;

import TicketMania.Entities.MusicEvent;
import TicketMania.Entities.Ticket;
import TicketMania.Services.MusicEventService;
import TicketMania.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(path = "/api")
public class MusicEventController {

    @Autowired
    private final MusicEventService musicEventService;
    @Autowired
    private final TicketService ticketService;

    public MusicEventController(MusicEventService musicEventService, TicketService ticketService) {
        this.musicEventService = musicEventService;
        this.ticketService = ticketService;
    }

    @GetMapping
    public String Hello() {
        return "Hello World";
    }

    @GetMapping(path = "/musicevents")
    public Collection<MusicEvent> getAll() {
        return this.musicEventService.getAll();
    }

    @GetMapping(path = "/musicevents/{id}")
    public ResponseEntity<MusicEvent> get(@PathVariable Long id) {
        try {
            MusicEvent musicEvent = musicEventService.getById(id);
            return new ResponseEntity<MusicEvent>(musicEvent, HttpStatus.OK);
        } catch (Exception ex) {
            throw ex;
        }
    }

   /* @GetMapping(path = "/{genre}")
    public ResponseEntity<MusicEvent> get(@RequestParam(name = "genre") String genre){
        try {
            MusicEvent musicEvent = musicEventService.getByGenre(genre);
            return new ResponseEntity<MusicEvent>(musicEvent, HttpStatus.OK);
        } catch (Exception ex) {
            throw ex;
        }
    }*/

    @PostMapping(path = "/musicevents")
    public ResponseEntity<MusicEvent> add(@RequestBody MusicEvent musicEvent) {
        try {
            musicEventService.save(musicEvent);
            return new ResponseEntity<MusicEvent>(musicEvent, HttpStatus.OK);
        } catch (Exception ex) {
            throw ex;
        }
    }

    // Adding artists/tickets with this specific update method only works if there are artists/tickets available in the database
    @PutMapping(path = "/musicevents/{id}")
    public ResponseEntity<MusicEvent> update(@RequestBody MusicEvent musicEvent, @PathVariable Long id) {
        try {
            if (musicEventService.getById(id) != null) {
                musicEventService.save(musicEvent);
            }
            return new ResponseEntity<MusicEvent>(musicEvent, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @PutMapping(path = "/musicevents/{id}/tickets/{type}")
    public ResponseEntity<MusicEvent> updateTickets(@RequestBody MusicEvent musicEvent, @PathVariable Long id, @PathVariable String type) {
        try {
            Ticket ticket = ticketService.findByType(type);
            if (musicEventService.getById(id) != null && ticket != null) {
                musicEvent.addTicket(ticket);
                musicEventService.save(musicEvent);
            }
            return new ResponseEntity<MusicEvent>(musicEvent, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

}
