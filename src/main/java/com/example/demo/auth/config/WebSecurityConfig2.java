package com.example.demo.auth.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.sql.DataSource;

/*
Uncomment the annotations below if you wish to use this security configuration file and comment these out in WebSecurityConfig1
*/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig2 extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    public WebSecurityConfig2(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationSuccessHandler authSuccessHandler() {
        return new AuthSuccessHandler();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //See: https://www.owasp.org/index.php/Cross-Site_Request_Forgery_(CSRF)
        //See: https://www.baeldung.com/spring-security-csrf
        //See: https://www.baeldung.com/csrf-thymeleaf-with-spring-security
        //http.csrf().disable();

        /*
            These pages can be public and not need auth
        */
        http.authorizeRequests().antMatchers("/", "/login", "/register", "/registration","/*.css","/*.JFIF").permitAll();

        /*
            Use built in login form
        */
        /*http.authorizeRequests().anyRequest().authenticated().and().formLogin()
                .defaultSuccessUrl("/userArea")
                .successHandler(authSuccessHandler());
         */

        /*
            Use a custom login form
        */
        http.authorizeRequests().anyRequest().authenticated().and().formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/viewEvents")
                .failureUrl("/login?error")
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler(authSuccessHandler());

    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .passwordEncoder(passwordEncoder())
                .dataSource(dataSource)
                /*
                Optional customised queries, e.g. if different tables are used
                 */
                .usersByUsernameQuery("select Email, password, enabled "
                + "from People "
                + "where Email = ?"
                )
                .authoritiesByUsernameQuery("select a.PeopleID, authority "
                + "from authorities a inner join People p on p.PeopleID = a.PeopleID "
                + "where Email = ?"
                );

    }

}