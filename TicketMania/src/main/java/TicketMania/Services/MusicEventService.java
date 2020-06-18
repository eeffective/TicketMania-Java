package TicketMania.Services;

import TicketMania.Entities.MusicEvent;
import TicketMania.Repositories.MusicEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class MusicEventService {

    @Autowired
    private final MusicEventRepository musicEventRepository;

    public MusicEventService(MusicEventRepository musicEventRepository) {
        this.musicEventRepository = musicEventRepository;
    }

    public void save(MusicEvent musicEvent) {
        try {
            musicEventRepository.save(musicEvent);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public Collection<MusicEvent> getAll() {
        try {
            return musicEventRepository.findAll();

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public Optional<MusicEvent> getById(Long id) {
        try {
            return musicEventRepository.findById(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public Collection<MusicEvent> getByLocation(String location) {
        try {
            return musicEventRepository.findByLocation(location);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public Collection<MusicEvent> getByArtist(String artist) {
        try {
            return musicEventRepository.findByMusicArtists(artist);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public Collection<MusicEvent> getByGenre(String genre){
        try {
            return musicEventRepository.findByGenre(genre);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
}
