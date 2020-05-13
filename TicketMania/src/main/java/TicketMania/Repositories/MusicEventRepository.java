package TicketMania.Repositories;

import TicketMania.Entities.MusicEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicEventRepository extends JpaRepository<MusicEvent, Long> {
    MusicEvent findByGenre(String genre);
}
