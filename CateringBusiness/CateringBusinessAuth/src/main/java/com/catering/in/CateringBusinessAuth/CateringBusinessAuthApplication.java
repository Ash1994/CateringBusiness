package com.catering.in.CateringBusinessAuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
public class CateringBusinessAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(CateringBusinessAuthApplication.class, args);
	}

}
