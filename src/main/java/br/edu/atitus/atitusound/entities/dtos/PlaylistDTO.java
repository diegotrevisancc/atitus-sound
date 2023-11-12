package br.edu.atitus.atitusound.entities.dtos;

import br.edu.atitus.atitusound.entities.MusicEntity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.util.List;

public class PlaylistDTO extends GenericDTO{
    private Boolean publicshare;
    private List<MusicEntity> musicEntityList;

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
