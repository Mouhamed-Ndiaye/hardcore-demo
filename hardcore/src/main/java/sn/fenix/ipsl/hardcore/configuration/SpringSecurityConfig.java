package sn.fenix.ipsl.hardcore.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import sn.fenix.ipsl.hardcore.service.UserService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(auth -> {
            auth.requestMatchers("/admin").hasRole("ADMIN");
            auth.requestMatchers("/user").hasRole("USER");
            auth.requestMatchers("/images/*","/css/*","/scripts/*").permitAll();
            auth.requestMatchers("/access-denied").permitAll();
            auth.requestMatchers("/register","/valide_register").permitAll();
            auth.anyRequest().authenticated();
        }).formLogin(formLogin -> formLogin.loginPage("/login").permitAll().defaultSuccessUrl("/",true)).exceptionHandling(exceptionHandling -> exceptionHandling.accessDeniedHandler(accessDeniedHandler())).build();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(userService.passwordEncoder());
    }




    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return (request, response, accessDeniedException) -> {
            // Redirection vers une page d'erreur personnalisée
            response.sendRedirect("/access-denied");
        };
    }



}
