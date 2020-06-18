package TicketMania.Repositories;

import TicketMania.Entities.MusicEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface MusicEventRepository extends JpaRepository<MusicEvent, Long> {
    Collection<MusicEvent> findByGenre(String genre);
    Collection<MusicEvent> findByLocation(String location);
    Collection<MusicEvent> findByMusicArtists(String musicArtist);
}
