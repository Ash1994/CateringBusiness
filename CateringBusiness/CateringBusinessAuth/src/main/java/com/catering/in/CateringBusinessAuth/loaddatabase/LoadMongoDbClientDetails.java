package com.catering.in.CateringBusinessAuth.loaddatabase;

import com.catering.in.CateringBusinessAuth.config.UserConfiguration;
import com.catering.in.CateringBusinessAuth.model.OauthClientDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadMongoDbClientDetails {

    @Bean
    CommandLineRunner loadPdfProp(UserConfiguration userConfiguration) {
        return args -> {
            log.info("Loading Client data in cache");
            userConfiguration.loadClientDetails(
                    new OauthClientDetails(
                            "catering",
                            "{bcrypt}$2a$10$xrCLg39Lv7dp9K7xFp1Eiu.WiuFPQyL27oIWdu4fMlFrBkhOiZ9P2",
                            "http://localhost:8088/code",
                            "READ,WRITE",
                            "3600",
                            "10000",
                            "inventory,payment",
                            "authorization_code,password,refresh_token,implicit",
                            "{}"
                    ));
            log.info("Loading Client data in cache completed");
        };
    }
}
