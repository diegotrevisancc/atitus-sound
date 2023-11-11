package br.edu.atitus.atitusound.repositories;

import br.edu.atitus.atitusound.entities.UserEntity;

import java.util.Optional;

public interface UserRepository extends GenericRepository<UserEntity>{
    Optional<UserEntity> findByUsername(String username);
}
