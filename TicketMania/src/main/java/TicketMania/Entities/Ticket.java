package TicketMania.Entities;

import TicketMania.Entities.Utilities.MusicEventTicket;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tickets")
@NaturalIdCache
@Cache(
        usage = CacheConcurrencyStrategy.READ_WRITE
)
public class Ticket {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MusicEventTicket> musicEvents = new HashSet<>();

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

    @Override
    public boolean equals(Object obj){
        if (obj == null) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Ticket ticket = (Ticket) obj;
        return Objects.equals(type, ticket.type);
    }

    @Override
    public int hashCode(){
        return Objects.hash(type);
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
