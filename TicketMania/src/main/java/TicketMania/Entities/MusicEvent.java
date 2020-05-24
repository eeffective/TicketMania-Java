package TicketMania.Entities;

import TicketMania.Entities.Utilities.MusicEventTicket;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "musicevents")
public class MusicEvent {
    // TODO: Add a image property
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "location")
    private String location;
    @Column(name = "genre")
    private String genre;
    @Column(name = "duration")
    private Integer duration;
    @Column(name = "datetime")
    private Date dateTime;
    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "musicevent_musicartist",
            joinColumns = @JoinColumn(name = "musicevent_id"),
            inverseJoinColumns = @JoinColumn(name = "musicartist_id"))
    private Set<MusicArtist> musicArtists = new HashSet<>();
    @OneToMany(mappedBy = "musicEvent", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MusicEventTicket> tickets = new HashSet<>();

    public MusicEvent(Long id, String name, String description, String location, String genre, Integer duration, Date dateTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.genre = genre;
        this.duration = duration;
        this.dateTime = dateTime;
    }

    public MusicEvent() {
    }

    public void addTicket(Ticket ticket){
        MusicEventTicket musicEventTicket = new MusicEventTicket(this, ticket);
        tickets.add(musicEventTicket);
        ticket.getMusicEvents().add(musicEventTicket);
    }

    public void removeTicket(Ticket ticket){
        for (Iterator<MusicEventTicket> iterator = tickets.iterator();
        iterator.hasNext();){
            MusicEventTicket musicEventTicket = iterator.next();

            if (musicEventTicket.getMusicEvent().equals(this) &&
            musicEventTicket.getTicket().equals(ticket)) {
                iterator.remove();
                musicEventTicket.getTicket().getMusicEvents().remove(musicEventTicket);
                musicEventTicket.setMusicEvent(null);
                musicEventTicket.setTicket(null);
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        MusicEvent musicEvent = (MusicEvent) obj;
        return Objects.equals(name, musicEvent.name) &&
                Objects.equals(dateTime, musicEvent.dateTime) &&
                Objects.equals(duration, musicEvent.duration) &&
                Objects.equals(genre, musicEvent.genre) &&
                Objects.equals(description, musicEvent.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Set<MusicEventTicket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<MusicEventTicket> tickets) {
        this.tickets = tickets;
    }

    public Set<MusicArtist> getMusicArtists() {
        return musicArtists;
    }

    public void setMusicArtists(Set<MusicArtist> musicArtists) {
        this.musicArtists = musicArtists;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
