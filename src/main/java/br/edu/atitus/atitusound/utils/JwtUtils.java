package br.edu.atitus.atitusound.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class JwtUtils {
    private String secretWord;

    public JwtUtils() throws Exception {
        this.secretWord = this.configureSecretWord();
        System.out.println(this.secretWord);
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
}
