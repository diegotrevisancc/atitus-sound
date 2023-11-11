package br.edu.atitus.atitusound.controllers;

import br.edu.atitus.atitusound.entities.MusicEntity;
import br.edu.atitus.atitusound.entities.dtos.MusicDTO;
import br.edu.atitus.atitusound.services.ArtistService;
import br.edu.atitus.atitusound.services.GenericService;
import br.edu.atitus.atitusound.services.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/musics")
public class MusicController extends GenericController<MusicEntity, MusicDTO>{
    @Autowired
    private MusicService musicService;

    @Override
    public GenericService<MusicEntity> getService() {
        return this.musicService;
    }

    @Override
    public MusicEntity convertDTO2Entity(MusicDTO dto) {
       MusicEntity musicEntity = new MusicEntity();
       musicEntity.setUrl(dto.getUrl());
       musicEntity.setName(dto.getName());
       musicEntity.setArtist(dto.getArtist());
       musicEntity.setDuration(dto.getDuration());
       musicEntity.setLikes_count(dto.getLikes_count());
       return musicEntity;
    }
}
