package br.edu.atitus.atitusound.repositories;

import br.edu.atitus.atitusound.entities.MusicEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends GenericRepository<MusicEntity> {
}
