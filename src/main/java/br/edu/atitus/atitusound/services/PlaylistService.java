package br.edu.atitus.atitusound.services;

import br.edu.atitus.atitusound.entities.PlaylistEntity;
import br.edu.atitus.atitusound.entities.UserEntity;
import br.edu.atitus.atitusound.repositories.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

public interface PlaylistService extends GenericService<PlaylistEntity>{
    Page<List<PlaylistEntity>> findByNameContainingIgnoreCase(String name, Pageable pageable) throws Exception;

}
