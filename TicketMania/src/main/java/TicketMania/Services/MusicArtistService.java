package TicketMania.Services;

import TicketMania.Entities.MusicArtist;
import TicketMania.Repositories.MusicArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MusicArtistService {
    @Autowired
    private final MusicArtistRepository musicArtistRepository;

    public MusicArtistService(MusicArtistRepository musicArtistRepository) {
        this.musicArtistRepository = musicArtistRepository;
    }

    public void save(MusicArtist musicArtist) {
        try {
            musicArtistRepository.save(musicArtist);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public MusicArtist getById(Long id) {
        try {
            return musicArtistRepository.findById(id).get();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public Collection<MusicArtist> getAll() {
        try {
            return musicArtistRepository.findAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
}
