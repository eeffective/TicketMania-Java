package TicketMania.Controllers;

import TicketMania.Entities.MusicEvent;
import TicketMania.Services.MusicEventService;
import TicketMania.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
            MusicEvent musicEvent = musicEventService.getById(id);
            return new ResponseEntity<MusicEvent>(musicEvent, HttpStatus.OK);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @GetMapping(path = "/genre/{genre}")
    public ResponseEntity<MusicEvent> getByGenre(@PathVariable String genre){
        try {
            MusicEvent musicEvent = musicEventService.getByGenre(genre);
            return new ResponseEntity<MusicEvent>(musicEvent, HttpStatus.OK);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @GetMapping(path = "/location/{location}")
    public ResponseEntity<MusicEvent> getBy(@PathVariable String location){
        try {
            MusicEvent musicEvent = musicEventService.getByLocation(location);
            return new ResponseEntity<MusicEvent>(musicEvent, HttpStatus.OK);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @PostMapping()
    public ResponseEntity<MusicEvent> add(@RequestBody MusicEvent musicEvent) {
        try {
            musicEventService.save(musicEvent);
            return new ResponseEntity<MusicEvent>(musicEvent, HttpStatus.OK);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<MusicEvent> update(@RequestBody MusicEvent musicEvent, @PathVariable Long id) {
        try {
            musicEventService.save(musicEvent);
            return new ResponseEntity<>(musicEvent, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }


}
