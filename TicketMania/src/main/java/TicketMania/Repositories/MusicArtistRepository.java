package TicketMania.Repositories;

import TicketMania.Models.MusicArtist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicArtistRepository extends JpaRepository<MusicArtist, Long> {
}
