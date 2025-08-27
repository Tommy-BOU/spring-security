package fr.diginamic.spring_security.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http

                .csrf(csrf -> csrf.disable())
//                .headers(headers -> headers
//                        .frameOptions(frameOptions -> frameOptions
//                        .sameOrigin()))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/hello").permitAll()
                        .anyRequest().authenticated())
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/hello-private", true)
//                        .failureUrl("/hello")
                        .permitAll())
                .logout(logout -> logout
                        .logoutSuccessUrl("/hello")
                        .permitAll())
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails user = User.withUsername("tbbk")
                .password("test")
                .roles("ADMIN")
                .build();

        UserDetails user1 = User.withUsername("user1")
                .password("user1")
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password("admin")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, user1, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
