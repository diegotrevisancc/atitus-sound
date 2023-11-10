package br.edu.atitus.atitusound.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;

import java.time.Duration;

@Entity
@Table(name = "music")
public class MusicEntity extends GenericEntity{
    private Duration duration;
    private Integer likes_count;
    private String url;
    @ManyToOne(fetch = FetchType.EAGER) //one artist have many musics
    @JoinColumn(name = "artist_uuid")
    private ArtistEntity artist;

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Integer getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(Integer likes_count) {
        this.likes_count = likes_count;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArtistEntity getArtist() {
        return artist;
    }

    public void setArtist(ArtistEntity artist) {
        this.artist = artist;
    }
}
