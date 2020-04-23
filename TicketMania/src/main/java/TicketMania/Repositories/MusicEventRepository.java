package TicketMania.Repositories;

import TicketMania.Models.MusicEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicEventRepository extends JpaRepository<MusicEvent, Long> {
}
