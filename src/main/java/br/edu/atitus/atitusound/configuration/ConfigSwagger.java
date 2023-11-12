package br.edu.atitus.atitusound.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigSwagger {
    @Bean
    public OpenAPI getOpenApi() {
        return new OpenAPI().info(new Info().title("Atitus Sound - API").description("Atitus Sound backend documentation").
                version("Version 1.0.0").contact(new Contact().name("Diego Trevisan").email("diego.trevisan.cc@gmail.com")));
    }
}
