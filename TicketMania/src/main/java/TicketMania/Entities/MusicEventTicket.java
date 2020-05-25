package TicketMania.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "musicevent_ticket")
public class MusicEventTicket implements Serializable {
    @Id
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "musicevent_id")
    private MusicEvent musicEvent;

    @Id
    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @Column(name = "amount")
    private int amount;

    @Column(name = "price")
    private double price;


    public MusicEvent getMusicEvent() {
        return this.musicEvent;
    }

    public void setMusicEvent(MusicEvent musicEvent) {
        this.musicEvent = musicEvent;
    }


    public Ticket getTicket() {
        return this.ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
