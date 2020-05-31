package com.catering.in.CateringBusinessLogin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@Slf4j
public class SpringJdbcConfig {

    @Bean(name = "h2DataSource")
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema/schema.sql")
                .addScript("classpath:schema/data.sql")
                .build();
    }

    @Bean(name = "gatewayDS")
    public NamedParameterJdbcTemplate gatewayDataTemplate(@Qualifier("h2DataSource") DataSource ds) {
        return new NamedParameterJdbcTemplate(ds);
    }
}
