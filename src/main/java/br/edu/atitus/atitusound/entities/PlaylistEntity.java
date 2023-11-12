package br.edu.atitus.atitusound.entities;

import jakarta.persistence.*;
import org.apache.catalina.User;
import org.hibernate.annotations.ManyToAny;

import java.util.List;

@Entity
@Table(name = "playlist")
public class PlaylistEntity extends GenericEntity {
    @Column(name = "public_share")
    private Boolean publicshare;
    @ManyToAny(fetch = FetchType.EAGER)
    @JoinTable(name = "playlist_music", joinColumns = @JoinColumn(name = "playlist_uuid"), inverseJoinColumns = @JoinColumn(name = "music_uuid"))
    private List<MusicEntity> musicEntityList;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_uuid", nullable = false)
    private UserEntity user; //will detect the user by token

    public UserEntity getUserEntity() {
        return user;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.user = userEntity;
    }

    public Boolean getPublicShare() {
        return publicshare;
    }

    public void setPublicShare(Boolean public_share) {
        this.publicshare = public_share;
    }

    public List<MusicEntity> getMusicEntityList() {
        return musicEntityList;
    }

    public void setMusicEntityList(List<MusicEntity> musicEntityList) {
        this.musicEntityList = musicEntityList;
    }
}
