package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

/**
 * Created by msnikitin on 20.04.2017.
 */
@Configuration
@EnableResourceServer
public class OAuth2Config extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/api/**")
                //.authorizeRequests().anyRequest().access("#oauth2.hasScope('read')");
                .authorizeRequests().anyRequest().authenticated();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("megaclient").tokenStore(tokenStore);
    }

//    @Bean
//    public RemoteTokenServices remoteTokenServices(@Value("${megaclient.client.tokenIntrospectionUri}") String checkTokenUrl,
//                                                   @Value("${megaclient.client.clientId}") String clientId,
//                                                   @Value("${megaclient.client.clientSecret}") String clientSecret) {
//        RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
//        remoteTokenServices.setCheckTokenEndpointUrl(checkTokenUrl);
//        remoteTokenServices.setClientId(clientId);
//        remoteTokenServices.setClientSecret(clientSecret);
//        return remoteTokenServices;
//    }

    @Autowired
    TokenStore tokenStore;
}
