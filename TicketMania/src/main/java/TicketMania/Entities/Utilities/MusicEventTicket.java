package TicketMania.Entities.Utilities;

import TicketMania.Entities.MusicEvent;
import TicketMania.Entities.Ticket;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "musicevent_ticket")
public class MusicEventTicket {
    @EmbeddedId
    private MusicEventTicketId id = new MusicEventTicketId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("musicEventId")
    private MusicEvent musicEvent;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("ticketId")
    private Ticket ticket;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "available_amount")
    private int availableAmount;

    public MusicEventTicket(MusicEvent musicEvent, Ticket ticket) {
        this.musicEvent = musicEvent;
        this.ticket = ticket;
        this.id = new MusicEventTicketId(musicEvent.getId(), ticket.getId());
    }

    public MusicEventTicket() {
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        MusicEventTicket that = (MusicEventTicket) obj;
        return Objects.equals(musicEvent, that.musicEvent) &&
                Objects.equals(ticket, that.ticket);
    }

    @Override
    public int hashCode(){
        return Objects.hash(musicEvent, ticket);
    }


    public MusicEventTicketId getId() {
        return id;
    }

    public void setId(MusicEventTicketId id) {
        this.id = id;
    }

    public MusicEvent getMusicEvent() {
        return musicEvent;
    }

    public void setMusicEvent(MusicEvent musicEvent) {
        this.musicEvent = musicEvent;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(int availableAmount) {
        this.availableAmount = availableAmount;
    }
}
