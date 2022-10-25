package com.workspaceit.socialmediaproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService getUserDetailsService(){
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder getPasswordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider getAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider= new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(getUserDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(getPasswordEncoder());

        return daoAuthenticationProvider;
    }
    /*
    //configure type of authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(getAuthenticationProvider());
    }
*/
    //configure which routes can be accessed by which users


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/user/login").permitAll()
                .antMatchers("/post/{userId}/{postId}/getUpvotes").permitAll()
                .antMatchers("/user/login/validation").permitAll()
                .antMatchers("/user/register").permitAll()
                .antMatchers("/user/addUser").permitAll()
                .antMatchers("/user/**").authenticated()
                .antMatchers("/post/**").authenticated()
                .antMatchers("/comment/**").authenticated()
                .antMatchers("/reaction/**").authenticated()
                .and().formLogin().defaultSuccessUrl("/user/login/validation");



    }



//    @Bean
//    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests()
//                .antMatchers("/user/login").permitAll()
//                .antMatchers("/user/login/validation").permitAll()
//                .antMatchers("/user/register").permitAll()
//                .antMatchers("/user/addUser").permitAll()
//                .antMatchers("/user/**").authenticated()
//                .antMatchers("/post/**").authenticated()
//                .antMatchers("/comment/**").authenticated()
//                .antMatchers("/reaction/**").authenticated()
//                .and().formLogin().defaultSuccessUrl("/user/login/validation");
//        return http.build();
//
//    }
}
