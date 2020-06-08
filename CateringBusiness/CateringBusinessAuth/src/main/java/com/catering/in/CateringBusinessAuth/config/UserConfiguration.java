package com.catering.in.CateringBusinessAuth.config;

import com.catering.in.CateringBusinessAuth.model.MongoDbOauthClientDetailsDao;
import com.catering.in.CateringBusinessAuth.model.OauthClientDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfiguration extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    MongoDbOauthClientDetailsDao mongoDbOauthClientDetailsDao;

    PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("ashwin")
                .password(passwordEncoder.encode("ashwin123"))
                .roles("USER", "ADMIN", "MANAGER")
                .authorities("CAN_READ", "CAN_WRITE", "CAN_DELETE")
                .and()
                .withUser("ayush")
                .password(passwordEncoder.encode("ayush123"))
                .roles("USER")
                .authorities("CAN_READ", "CAN_WRITE");
    }

    public void loadClientDetails(OauthClientDetails oauthClientDetails) {
        mongoDbOauthClientDetailsDao.save(oauthClientDetails);
    }
}
