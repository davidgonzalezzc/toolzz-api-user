package puj.api.userapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
/***
 * Clase de configuración CORS
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception{
        return http
            .csrf(crsf -> crsf.disable())
            .authorizeRequests(auth -> {
                auth.requestMatchers("/").permitAll();
                auth.requestMatchers("/admin").hasRole("ADMIN");
                
            })
            .httpBasic(Customizer.withDefaults())
            .build();
    }
}
