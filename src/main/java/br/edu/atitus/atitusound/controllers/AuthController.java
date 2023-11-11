package br.edu.atitus.atitusound.controllers;

import br.edu.atitus.atitusound.entities.ArtistEntity;
import br.edu.atitus.atitusound.entities.UserEntity;
import br.edu.atitus.atitusound.entities.dtos.LoginDTO;
import br.edu.atitus.atitusound.entities.dtos.UserDTO;
import br.edu.atitus.atitusound.services.UserService;
import br.edu.atitus.atitusound.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    @PostMapping("/signup")
    public ResponseEntity<UserEntity> postSignup(@RequestBody UserDTO dto) throws Exception {
        UserEntity user = new UserEntity();

        user.setName(dto.getName());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        try {
            this.userService.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        } catch (Exception exception) {
            return ResponseEntity.badRequest().header("error", exception.getMessage()).build();
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<String> postSignin(@RequestBody LoginDTO dto) {
        try {
            var auth = this.authenticationConfiguration.getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
            return ResponseEntity.ok(new JwtUtils().generateTokenFromUsername(dto.getUsername()));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).header("erro", exception.getMessage()).build();
        }
    }
}
