package TicketMania.Controllers;

import TicketMania.Entities.MusicEvent;
import TicketMania.Services.MusicEventService;
import TicketMania.Services.TicketService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(path = "/api/musicevents")
public class MusicEventController {

    @Autowired
    private final MusicEventService musicEventService;
    @Autowired
    private final TicketService ticketService;

    public MusicEventController(MusicEventService musicEventService, TicketService ticketService) {
        this.musicEventService = musicEventService;
        this.ticketService = ticketService;
    }

    @GetMapping()
    public Collection<MusicEvent> getAll() {
        return this.musicEventService.getAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<MusicEvent> getById(@PathVariable Long id) {
        try {
            MusicEvent musicEvent = musicEventService.getById(id).get();
            return new ResponseEntity<MusicEvent>(musicEvent, HttpStatus.OK);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @GetMapping(path = "/genre/{genre}")
    public Collection<MusicEvent> getByGenre(@PathVariable String genre) {
        try {
            return musicEventService.getByGenre(genre);
        } catch (Exception ex) {
            throw ex;
        }
    }


    @GetMapping(path = "/location/{location}")
    public Collection<MusicEvent> getBy(@PathVariable String location) {
        try {
            return musicEventService.getByLocation(location);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public ResponseEntity<MusicEvent> add(@RequestBody MusicEvent musicEvent) {
        try {
            musicEventService.save(musicEvent);
            return new ResponseEntity<MusicEvent>(musicEvent, HttpStatus.OK);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(path = "/{id}")
    public ResponseEntity<MusicEvent> update(@RequestBody MusicEvent musicEvent, @PathVariable Long id) {
        return musicEventService.getById(id)
                .map(event -> {
                    event = musicEvent;
                    musicEventService.save(event);
                    return new ResponseEntity<MusicEvent>(event, HttpStatus.OK);
                })
                .orElseGet(() -> {
                    musicEvent.setId(id);
                    musicEventService.save(musicEvent);
                    return new ResponseEntity<>(musicEvent, HttpStatus.ACCEPTED);
                });
    }



}
