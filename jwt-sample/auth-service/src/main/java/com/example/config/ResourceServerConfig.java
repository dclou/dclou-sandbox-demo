package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * Created by msnikitin on 24.04.2017.
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("megaclient");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // only secure channel, https, is allowed
        //http.requiresChannel().anyRequest().requiresSecure();

        // static resources
        //http.authorizeRequests().antMatchers("/bootstrap/**").permitAll();

        //http.authorizeRequests().antMatchers("/api/**").access("#oauth2.hasScope('read')");//authenticated();

        http
                .antMatcher("/api/**")
                //.authorizeRequests().anyRequest().access("hasRole('USER') and #oauth2.isUser() and #oauth2.hasScope('user') and #oauth2.clientHasRole('CLIENT_ROLE1')");
                //.authorizeRequests().anyRequest().access("#oauth2.isUser() and #oauth2.hasScope('user') and #oauth2.clientHasRole('CLIENT_ROLE1')");
                .authorizeRequests().anyRequest().authenticated();
    }
}
