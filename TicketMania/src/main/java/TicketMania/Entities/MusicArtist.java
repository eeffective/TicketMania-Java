package TicketMania.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "musicartists")
public class MusicArtist {
    // TODO: Add a image property
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "biography")
    private String biography;
    @Column(name = "genre")
    private String genre;
    @JsonIgnore
    @ManyToMany(mappedBy = "musicArtists")
    private Set<MusicEvent> events = new HashSet<>();

    public MusicArtist() {
    }

    public MusicArtist(Long id, String name, String biography, String genre) {
        this.id = id;
        this.name = name;
        this.biography = biography;
        this.genre = genre;
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

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
