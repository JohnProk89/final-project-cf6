package gr.aueb.cf.finalprojectcf6.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfiguration(
            JwtAuthenticationFilter jwtAuthenticationFilter,
            AuthenticationProvider authenticationProvider
    ) {
        this.authenticationProvider = authenticationProvider;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry
                        .requestMatchers("/auth/**")
                        //.requestMatchers("/user/register").permitAll()
//                        .requestMatchers("/user/login").permitAll()
//                        .requestMatchers("/user/update").hasAnyAuthority(Role.PLAYER.name())
//                        .requestMatchers("/user/delete/").hasAnyAuthority(Role.SUPER_ADMIN.name())
//                        .requestMatchers("/user/get/{id}").hasAnyAuthority(Role.SUPER_ADMIN.name())
//                        .requestMatchers("/user/get/all").hasAnyAuthority(Role.SUPER_ADMIN.name())
//                        .requestMatchers("/user/favorgame").hasAnyAuthority(Role.PLAYER.name())
//                        .requestMatchers("/game/register").hasAnyAuthority(Role.SUPER_ADMIN.name())
//                        .requestMatchers("/game/get/{id}").hasAnyAuthority(Role.SUPER_ADMIN.name())
//                        .requestMatchers("/game/get/all").hasAnyAuthority(Role.SUPER_ADMIN.name())
//                        .requestMatchers("/game/update").hasAnyAuthority(Role.SUPER_ADMIN.name())
//                        .requestMatchers("/game/delete/").hasAnyAuthority(Role.SUPER_ADMIN.name())
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                .sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOrigins(List.of("http://localhost"));
        configuration.setAllowedMethods(List.of("GET","POST"));
        configuration.setAllowedHeaders(List.of("Authorization","Content-Type"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**",configuration);

        return source;
    }
}