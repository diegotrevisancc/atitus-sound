package br.edu.atitus.atitusound.services_implementation;

import br.edu.atitus.atitusound.entities.PlaylistEntity;
import br.edu.atitus.atitusound.repositories.GenericRepository;
import br.edu.atitus.atitusound.repositories.PlaylistRepository;
import br.edu.atitus.atitusound.services.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaylistServiceImplementation implements PlaylistService {
    @Autowired
    private PlaylistRepository playlistRepository;
    @Override
    public GenericRepository<PlaylistEntity> getRepository() {
        return this.playlistRepository;
    }
}
