package br.edu.atitus.atitusound.services_implementation;

import br.edu.atitus.atitusound.entities.UserEntity;
import br.edu.atitus.atitusound.repositories.GenericRepository;
import br.edu.atitus.atitusound.repositories.UserRepository;
import br.edu.atitus.atitusound.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.rmi.server.ExportException;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public GenericRepository<UserEntity> getRepository() {
        return this.userRepository;
    }

    @Override
    public void validate(UserEntity userEntity) throws Exception {
        UserService.super.validate(userEntity);
        if (userEntity.getUsername() == null || userEntity.getUsername().isEmpty()) {
            throw new Exception("invalid username");
        }

        if (userEntity.getUuid() == null) {
            if (this.userRepository.existsByUsername(userEntity.getUsername())) {
                throw new Exception("There is already a user registered with this username");
            }
        } else {
            if (this.userRepository.existsByNameAndUuidNot(userEntity.getUsername(), userEntity.getUuid())) {
                throw new Exception("There is already a user registered with this username");
            }
        }

        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword())); // turns password into an encoded password
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = this.userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("cannot found username in database"));
        return user;
    }
}
