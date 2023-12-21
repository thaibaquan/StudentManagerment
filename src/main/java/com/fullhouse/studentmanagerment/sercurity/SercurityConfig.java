//package com.fullhouse.studentmanagerment.sercurity;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SercurityConfig {
//    @Autowired
//    CustomerUserDetailService customerUserDetailService;
//
//    @Bean
//    WebSecurityCustomizer webSecurity() {
//        return (web) -> web.ignoring().requestMatchers("/css/**",  "/assets/**",
//                "/js/**",  "/static/**" , "/img/**","/demo/**");
//    }
//    @Bean
//    public static PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(crsf -> crsf.disable())
//                .authorizeHttpRequests((auth) -> auth
//                        .requestMatchers("/login",
//                                "/css/**","/js/**","/assets/**","/demo/**","/img/**").permitAll()
//                        .requestMatchers("/admin/**").hasRole("ADMIN")
//                        .anyRequest().authenticated()
//
//                )
//                .formLogin((form) -> form
//                        .loginPage("/login")
//                        .usernameParameter("email")
//                        .passwordParameter("password")
//                        .loginProcessingUrl("/login")
//                        .successHandler((request, response, authentication) -> {
//
//                            if (authentication.getAuthorities().stream()
//                                    .anyMatch(authority -> authority.getAuthority().equals("ADMIN"))) {
//                                response.sendRedirect("/admin/organization");
//                            }else {
//                                response.sendRedirect("/admin/index");
//                            }})
//                        .failureUrl("/login?error=true").permitAll()
//                )
//                .rememberMe(me -> me.key("uniqueAndSecret").userDetailsService(customerUserDetailService))
//                .logout(logout -> logout
//                        .logoutUrl("/logout")
//                        .logoutSuccessUrl("/login?logout=true")
//                        .invalidateHttpSession(true)
//                        .deleteCookies("JSESSIONID"));
//
//
////                        logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll());
//        return http.build();
//    }
//
//
//
//
////    public void configure(AuthenticationManagerBuilder builder) throws  Exception{
////
////        builder.userDetailsService(customerUserDetailService).passwordEncoder(passwordEncoder());
////
////    }
//
//}
