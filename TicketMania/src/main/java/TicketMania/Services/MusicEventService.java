package TicketMania.Services;

import TicketMania.Entities.MusicEvent;
import TicketMania.Repositories.MusicEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MusicEventService {

    @Autowired
    private final MusicEventRepository musicEventRepository;

    public MusicEventService(MusicEventRepository musicEventRepository) {
        this.musicEventRepository = musicEventRepository;
    }

    public void create(MusicEvent musicEvent){
        try {
            musicEventRepository.save(musicEvent);
        }catch (Exception ex){
            ex.printStackTrace();
            throw ex;
        }
    }

    public Collection<MusicEvent> getAll(){
        return musicEventRepository.findAll();
    }

    public MusicEvent getById(Long id){
        return musicEventRepository.findById(id).get();
    }
}
