package TicketMania.Entities;

import javax.persistence.*;

@Entity
@Table(name = "visited_musicevent")
public class VisitedMusicEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE } )
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE } )
    @JoinColumn(name = "musicevent_id")
    private MusicEvent musicEvent;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE } )
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;



}
