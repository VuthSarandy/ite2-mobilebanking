package co.istad.mobilebankingapi.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity //disable default spring security configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final PasswordEncoder passwordEncoder;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        // TODO: your security logic
        httpSecurity
                .authorizeHttpRequests(request -> request
                        .requestMatchers(HttpMethod.POST, "api/v1/users/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "api/v1/users/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "api/v1/users/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "api/v1/users/**").hasAnyRole("ADMIN", "STAFF")

                        .anyRequest()
                        .authenticated());
        // Enable spring security configuration of enable form basic username password
        httpSecurity.httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }

    @Bean
    InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        UserDetails userDetails = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("123"))
                .roles("USER", "ADMIN")
                .build();

        UserDetails userEditor = User.builder()
                .username("staff")
                .password(passwordEncoder.encode("123"))
                .roles("USER", "STAFF")
                .build();

        manager.createUser(userDetails);
        manager.createUser(userEditor);

        return manager;
    }

}