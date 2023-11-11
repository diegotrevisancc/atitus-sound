package br.edu.atitus.atitusound.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @class ConfigSecurityFilterChain
 *  This class configure all the security filter chain used in this application. The flow is something like:
 *  client -> http security filter -> server
 *  if the server succeed the authentication:
 *      server -> token -> client -> can do any request to any controller using this token.
 *  else:
 *      server cannot create token because something is wrong with user login
 *
 *  Why disable the csrf authentication?
 *  The spring documentation suggest:
 *
 * "Our recommendation is to use CSRF protection for any request that could be processed by a browser by normal users.
 *  If you are only creating a service that is used by non-browser clients, you will likely want to disable CSRF protection."
 *
 *  Also: Simplify all the interaction between server and non-browser clients.
 *
 *
 *  Why using Stateless policy?
 *  We are not dealing with sessions in this application, all the authentication is doing by jwt tokens.
 */

@Configuration
public class ConfigSecurityFilterChain {

    @Bean
    public SecurityFilterChain getFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth.requestMatchers("/auth/**").permitAll().anyRequest().authenticated()).httpBasic();

        return httpSecurity.build();
    }
}
