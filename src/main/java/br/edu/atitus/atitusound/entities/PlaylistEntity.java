package br.edu.atitus.atitusound.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "playlist")
public class PlaylistEntity extends GenericEntity {
    private Boolean publicShare;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "playlist_music")
    private List<MusicEntity> musicEntityList;

    public Boolean getPublicShare() {
        return publicShare;
    }

    public void setPublicShare(Boolean publicShare) {
        this.publicShare = publicShare;
    }

    public List<MusicEntity> getMusicEntityList() {
        return musicEntityList;
    }

    public void setMusicEntityList(List<MusicEntity> musicEntityList) {
        this.musicEntityList = musicEntityList;
    }
}
