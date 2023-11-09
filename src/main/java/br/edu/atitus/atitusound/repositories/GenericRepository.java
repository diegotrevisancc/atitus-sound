package br.edu.atitus.atitusound.repositories;

import java.util.List;
import java.util.UUID;

import br.edu.atitus.atitusound.entities.GenericEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<TEntity extends GenericEntity> extends JpaRepository<TEntity, UUID>{

    Boolean existsByName(String name);

    Boolean existsByNameAndUuidNot(String name, UUID uuid);

    Page<List<TEntity>> findByNameContainingIgnoreCase(Pageable pageable, String name);

}