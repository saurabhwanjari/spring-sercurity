package com.spring_sercurity.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(customizer->customizer.disable()); //desable crsr you can add data without authentication
        //can use get and other apis also
        http.authorizeHttpRequests(request ->request.anyRequest().authenticated());
        //authentication is appllied in above line all apis need some authentication but how because no form appear

//        http.formLogin(Customizer.withDefaults());

       /* to get the form we have use above line it will provide the form login but the postman output
        gives the form in response not exact output for that you need some configuration like below
        to allow rest apis  */

        http.httpBasic(Customizer.withDefaults()); // allow rest apis
        /*at this stage the api allows the post request to enter the data with
         use credential not with csrf ,
        also at this stage
        you can disable the formlogin if you want because httpBasic itself provide
        the pop up form and can be use in postman also
         */

        http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return  http.build();
    }

    @Bean
    UserDetailsService userDetailsService(){
        UserDetails user1 = User.withDefaultPasswordEncoder()
                .username("saurabh")
                .password("s@123")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user1);
    }
}