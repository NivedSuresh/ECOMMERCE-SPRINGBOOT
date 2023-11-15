package com.ecommerce.admin.Config;

import com.ecommerce.admin.Auth.CustomAuthenticationDetailsSource;
import com.ecommerce.admin.Handler.CustomSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class AdminSecurityConfiguration {

    CustomSuccessHandler successHandler;
    CustomAuthenticationDetailsSource customAuthenticationDetailsSource;

    @Autowired
    public AdminSecurityConfiguration(CustomSuccessHandler successHandler,
                                      CustomAuthenticationDetailsSource customAuthenticationDetailsSource) {
        this.successHandler = successHandler;
        this.customAuthenticationDetailsSource = customAuthenticationDetailsSource;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf-> csrf
                .requireCsrfProtectionMatcher(new AntPathRequestMatcher("/admin/authenticate"))
                .ignoringRequestMatchers("/admin", "/product-details/**"));

        http.authorizeHttpRequests(authorize -> authorize
                                .requestMatchers("/static/**","/css/**", "/fonts/**", "/imgs/**","/js/**","/sass/**", "/product-images").permitAll()
                                .requestMatchers("/admin/send-otp","/admin/forgot-password", "admin/login",
                                        "/admin/send-token", "/admin/reset-password").permitAll()
                                .requestMatchers("/admin/forgot-password").permitAll()
                                .anyRequest().hasAuthority("ADMIN"))


                .formLogin(formLogin -> formLogin
                            .loginPage("/admin/login")
                            .usernameParameter("username")
                            .passwordParameter("password")
                            .loginProcessingUrl("/admin/authenticate")
                            .successHandler(successHandler)
                        .authenticationDetailsSource(customAuthenticationDetailsSource))

                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/admin/logout"))
                        .logoutSuccessUrl("/admin/login?logout")
                        .invalidateHttpSession(true))

                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                        .invalidSessionUrl("/admin/login?expired"));


        return http.build();
    }
}
