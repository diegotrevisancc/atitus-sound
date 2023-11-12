package br.edu.atitus.atitusound.services_implementation;

import br.edu.atitus.atitusound.entities.PlaylistEntity;
import br.edu.atitus.atitusound.entities.UserEntity;
import br.edu.atitus.atitusound.repositories.GenericRepository;
import br.edu.atitus.atitusound.repositories.PlaylistRepository;
import br.edu.atitus.atitusound.services.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistServiceImplementation implements PlaylistService {
    @Autowired
    private PlaylistRepository playlistRepository;
    @Override
    public GenericRepository<PlaylistEntity> getRepository() {
        return this.playlistRepository;
    }

    @Override
    public void validate(PlaylistEntity playlistEntity) throws Exception {
        PlaylistService.super.validate(playlistEntity);
        UserEntity userEntity = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); //get the user by the jwt token using context
        playlistEntity.setUserEntity(userEntity);
    }

    @Override
    public Page<List<PlaylistEntity>> findByNameContainingIgnoreCase(String name, Pageable pageable) throws Exception {
        UserEntity userEntity = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("passando na classe do playlistserviceimp");
        return this.playlistRepository.findByNameContainingIgnoreCaseAndUserOrPublicshare(name, userEntity, true, pageable);
    }
}
