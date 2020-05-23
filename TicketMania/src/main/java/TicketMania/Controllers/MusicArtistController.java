package TicketMania.Controllers;

import TicketMania.Entities.MusicArtist;
import TicketMania.Entities.MusicEvent;
import TicketMania.Services.MusicArtistService;
import TicketMania.Services.MusicEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(path = "/api")
public class MusicArtistController {

    @Autowired
    private final MusicArtistService musicArtistService;

    public MusicArtistController(MusicArtistService musicArtistService) {
        this.musicArtistService = musicArtistService;
    }

    @GetMapping(path = "/musicartists")
    public Collection<MusicArtist> getAll() {
        return this.musicArtistService.getAll();
    }

    @GetMapping(path = "/musicartists/{id}")
    public ResponseEntity<MusicArtist> get(@PathVariable Long id) {
        try {
            MusicArtist musicArtist = musicArtistService.getById(id);
            return new ResponseEntity<MusicArtist>(musicArtist, HttpStatus.OK);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @PostMapping(path = "/musicartists")
    public ResponseEntity<MusicArtist> add(@RequestBody MusicArtist musicArtist) {
        try {
            musicArtistService.save(musicArtist);
            return new ResponseEntity<MusicArtist>(musicArtist, HttpStatus.OK);
        } catch (Exception ex) {
            throw ex;
        }
    }
}
