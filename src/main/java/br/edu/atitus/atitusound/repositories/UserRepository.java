package br.edu.atitus.atitusound.repositories;

import br.edu.atitus.atitusound.entities.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends GenericRepository<UserEntity>{
    Optional<UserEntity> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByUsernameAndUuidNot(String username, UUID uuid);
}
