package TicketMania.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type")
    private String type;
    @JsonIgnore
    @OneToMany(mappedBy = "ticket")
    private Set<MusicEventTicket> musicEvents = new HashSet<MusicEventTicket>();
    @JsonIgnore
    @OneToMany(mappedBy = "ticket", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<VisitedMusicEvent> visitedMusicEvents = new HashSet<>();

    public Ticket() {
    }

    public Set<MusicEventTicket> getMusicEvents() {
        return musicEvents;
    }

    public void setMusicEvents(Set<MusicEventTicket> musicEvents) {
        this.musicEvents = musicEvents;
    }

    public Ticket(String type){
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
