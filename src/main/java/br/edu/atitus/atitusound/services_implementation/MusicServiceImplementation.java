package br.edu.atitus.atitusound.services_implementation;

import br.edu.atitus.atitusound.entities.MusicEntity;
import br.edu.atitus.atitusound.repositories.GenericRepository;
import br.edu.atitus.atitusound.repositories.MusicRepository;
import br.edu.atitus.atitusound.services.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicServiceImplementation implements MusicService {
    @Autowired
    private MusicRepository musicRepository;
    @Override
    public GenericRepository<MusicEntity> getRepository() {
        return this.musicRepository;
    }
}
