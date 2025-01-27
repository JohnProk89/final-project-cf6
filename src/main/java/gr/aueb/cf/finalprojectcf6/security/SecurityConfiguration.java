//package gr.aueb.cf.finalprojectcf6.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration {
//
//    @Bean
//    public SecurityFilterChain springSecurityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .cors(CorsConfigurer::disable)
//                .csrf(AbstractHttpConfigurer::disable)
////                .exceptionHandling(exceptions -> exceptions.authenticationEntryPoint(myCustomAuthenticationEntryPoint()))
//                .authorizeHttpRequests(request -> request
//                        .requestMatchers("/user/register").permitAll()
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
//                )
//
//
//    }
//}
