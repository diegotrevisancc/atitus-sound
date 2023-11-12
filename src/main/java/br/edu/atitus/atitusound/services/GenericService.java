package br.edu.atitus.atitusound.services;

import br.edu.atitus.atitusound.entities.GenericEntity;
import br.edu.atitus.atitusound.repositories.GenericRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GenericService <TEntidade extends GenericEntity>{

    public GenericRepository<TEntidade> getRepository();
    // se uma classe que implementar essa interface não sobreescrever esse método essa será a impl default.
    default void validate(TEntidade entity) throws Exception {
        boolean isNameNotValid = entity.getName() == null || entity.getName().isEmpty();
        if (isNameNotValid) {
            throw new Exception("It is necessary to inform a valid name");
        }
        if (entity.getUuid() == null) {
            if (this.getRepository().existsByName(entity.getName())) {
                throw new Exception("This name already exist");
            }
        } else {
            if (!this.getRepository().existsById((entity.getUuid()))) {
                throw new Exception("This uuid already exist");
            }
            if (this.getRepository().existsByNameAndUuidNot(entity.getName(), entity.getUuid())) {
                throw new Exception("This name already exist");
            }
        }
    }

    default TEntidade save(TEntidade entity) throws Exception {
        this.validate(entity);
        return getRepository().save(entity);
    }


    default List<TEntidade> findAll() throws Exception {
        return getRepository().findAll();
    }


    default Optional<TEntidade> findById(UUID uuid) throws Exception {
        return getRepository().findById(uuid);
    }


    default void deleteById(UUID uuid) throws Exception {
        if (!getRepository().existsById(uuid))
            throw new Exception("Não existe registro com este UUID");
        getRepository().deleteById(uuid);
    }


    default Page<List<TEntidade>> findByNameContainingIgnoreCase(Pageable pageable, String name) throws Exception {
        System.out.println("Passando no método da Generic Service");
        return getRepository().findByNameContainingIgnoreCase(pageable, name);
    }
}
