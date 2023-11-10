package br.edu.atitus.atitusound.controllers;

import br.edu.atitus.atitusound.entities.ArtistEntity;
import br.edu.atitus.atitusound.entities.dtos.ArtistDTO;
import br.edu.atitus.atitusound.services.ArtistService;
import br.edu.atitus.atitusound.services.GenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artists")
public class ArtistController extends GenericController<ArtistEntity, ArtistDTO>{
    private ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        super();
        this.artistService = artistService;
    }

    protected ArtistEntity convertDTO2Entity(ArtistDTO dto) {
        ArtistEntity entidade = new ArtistEntity();
        entidade.setName(dto.getName());
        entidade.setImage(dto.getImage());
        return entidade;
    }

    @Override
    GenericService<ArtistEntity> getService() {
        return artistService;
    }

}