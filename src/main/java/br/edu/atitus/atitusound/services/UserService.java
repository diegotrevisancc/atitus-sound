package br.edu.atitus.atitusound.services;

import br.edu.atitus.atitusound.entities.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends GenericService<UserEntity>, UserDetailsService {
}
