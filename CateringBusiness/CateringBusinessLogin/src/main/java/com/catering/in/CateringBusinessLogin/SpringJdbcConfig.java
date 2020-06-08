package com.catering.in.CateringBusinessLogin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class SpringJdbcConfig {

//    @Bean
//    CommandLineRunner loadPdfProp(UserServiceDao dao) {
//        return args -> {
//            log.info("Loading data in cache");
//            dao.getUserById(1);
//            log.info("Loading data in cache completed");
//        };
//    }


//    @Bean(name = "h2DataSource")
//    @Primary
//    public DataSource embeddedDataSource() {
//        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("classpath:schema.sql")
//                .build();
//    }

//    @Bean(name = "gatewayDS")
//    @ConfigurationProperties(prefix = "spring.documentdatasource")
//    public DataSource pdfLibDataSource() throws Exception {
//        return DataSourceBuilder.create().build();
//    }
}
