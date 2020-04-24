package TicketMania.Controllers;

import TicketMania.Entities.MusicEvent;
import TicketMania.Services.MusicEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(path = "/musicevents")
public class MusicEventController {

    @Autowired
    private final MusicEventService musicEventService;

    public MusicEventController(MusicEventService musicEventService) {
        this.musicEventService = musicEventService;
    }

    @GetMapping
    public Collection<MusicEvent> getAll() {
        return this.musicEventService.getAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<MusicEvent> get(@PathVariable Long id) {
        try {
            MusicEvent musicEvent = musicEventService.getById(id);
            return new ResponseEntity<MusicEvent>(musicEvent, HttpStatus.OK);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @PostMapping
    public ResponseEntity<MusicEvent> add(@RequestBody MusicEvent musicEvent) {
        try {
            musicEventService.create(musicEvent);
            return new ResponseEntity<MusicEvent>(musicEvent, HttpStatus.OK);
        } catch (Exception ex) {
            throw ex;
        }
    }
}
