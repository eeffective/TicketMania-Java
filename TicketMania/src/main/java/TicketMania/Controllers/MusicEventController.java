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
@RequestMapping(path = "/api")
public class MusicEventController {

    @Autowired
    private final MusicEventService musicEventService;

    public MusicEventController(MusicEventService musicEventService) {
        this.musicEventService = musicEventService;
    }

    @GetMapping
    public String Hello(){
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

}
