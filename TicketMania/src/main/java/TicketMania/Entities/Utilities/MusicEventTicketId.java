package TicketMania.Entities.Utilities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MusicEventTicketId implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "musicevent_id")
    private Long musicEventId;
    @Column(name = "ticket_id")
    private Long ticketId;

    public MusicEventTicketId(Long musicEventId, Long ticketId) {
        super();
        this.musicEventId = musicEventId;
        this.ticketId = ticketId;
    }

    public MusicEventTicketId() {
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        MusicEventTicketId that = (MusicEventTicketId) obj;
        return Objects.equals(musicEventId, that.musicEventId) &&
                Objects.equals(ticketId, that.ticketId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(musicEventId, ticketId);
    }
}
