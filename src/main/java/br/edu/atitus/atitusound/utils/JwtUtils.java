package br.edu.atitus.atitusound.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

import java.io.FileInputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.util.Date;
import java.util.Properties;

public class JwtUtils {
    private String secretWord;
    private final static int jwtExpirationMs = 86400000;

    public JwtUtils() throws Exception {
        this.secretWord = this.configureSecretWord();
    }

    private String configureSecretWord() throws Exception {
        try {
            FileInputStream inputStream = new FileInputStream("src/main/resources/application.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            inputStream.close();
            return properties.getProperty("secret-word");
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(this.secretWord));
    }

    public String generateTokenFromUsername(String username) throws InvalidKeyException {
        return Jwts.builder().setSubject(username).setIssuedAt(new Date()).
                setExpiration(new Date(new Date().getTime() + jwtExpirationMs)).
                signWith(this.key(), SignatureAlgorithm.HS256).compact();
    }

    public String getUsernameFromJwtToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJwt(token).getBody().getSubject();
    }

    public String getJwtFromRequest(HttpServletRequest request) {
        String jwt = request.getHeader("Authorization");
        boolean isJwtValid = jwt != null && !jwt.isEmpty();
        if (isJwtValid) {
            return jwt.substring(7);
        }
        return null;
    }

    public boolean validateJwtToken(String jwt) {
        try {
            Jwts.parserBuilder().setSigningKey(this.key()).build().parse(jwt);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
