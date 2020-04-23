package TicketMania.Models;

import javax.persistence.*;
import java.util.Date;

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
