package br.edu.atitus.atitusound.services_implementation;

import br.edu.atitus.atitusound.entities.ArtistEntity;
import br.edu.atitus.atitusound.repositories.ArtistRepository;
import br.edu.atitus.atitusound.repositories.GenericRepository;
import br.edu.atitus.atitusound.services.ArtistService;
import org.springframework.stereotype.Service;

@Service
public class ArtistServiceImplementation implements ArtistService {
    private ArtistRepository artistRepository;

    public ArtistServiceImplementation(ArtistRepository artistRepository) {
        super();
        this.artistRepository = artistRepository;
    }

    @Override
    public GenericRepository<ArtistEntity> getRepository() {
        return artistRepository;
    }

}
