package br.edu.atitus.atitusound.entities.dtos;

import br.edu.atitus.atitusound.entities.MusicEntity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.util.List;

public class PlaylistDTO extends GenericDTO{
    private Boolean publicShare;
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
