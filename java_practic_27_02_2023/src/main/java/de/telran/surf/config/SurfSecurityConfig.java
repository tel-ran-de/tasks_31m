package de.telran.surf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SurfSecurityConfig  {

    @Autowired
    private UserDetailsService userService;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        String[] permitRes = {"/", "/image/**",
                "/styles/**", "/fonts/**", "/font-awesome-4.7.0/**", "/images/**",
                "/registration", "/js/**"};
        http.authorizeRequests()
                .mvcMatchers(permitRes).permitAll()
                .anyRequest().fullyAuthenticated();
        http.formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .permitAll();
        http.logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll();
        http.userDetailsService(userService);

        return http.build();
    }

}
