package br.edu.atitus.atitusound.controllers;

import br.edu.atitus.atitusound.entities.PlaylistEntity;
import br.edu.atitus.atitusound.entities.dtos.PlaylistDTO;
import br.edu.atitus.atitusound.services.GenericService;
import br.edu.atitus.atitusound.services.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/playlists")
public class PlaylistController extends GenericController<PlaylistEntity, PlaylistDTO>{
    @Autowired
    private PlaylistService playlistService;
    @Override
    public GenericService<PlaylistEntity> getService() {
        return this.playlistService;
    }
    @Override
    public PlaylistEntity convertDTO2Entity(PlaylistDTO dto) {
        PlaylistEntity playlistEntity = new PlaylistEntity();
        playlistEntity.setName(dto.getName());
        playlistEntity.setMusicEntityList(dto.getMusicEntityList());
        playlistEntity.setPublicShare(dto.getPublicShare());
        return playlistEntity;
    }
}
