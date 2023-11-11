package br.edu.atitus.atitusound.repositories;

import br.edu.atitus.atitusound.entities.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends GenericRepository<UserEntity>{
    Optional<UserEntity> findByUsername(String username);
}
