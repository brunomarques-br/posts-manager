package br.com.sisblog.config;

import br.com.sisblog.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("dev")
public class DevConfig {

    private final DbService dbService;

    @Autowired
    public DevConfig(DbService dbService) {
        this.dbService = dbService;
    }

    /*Creating a pattern strategy to control in creation of a database.*/
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Bean
    public boolean instantiateDatabase() throws ParseException {

        if (!"create".equals(strategy))
            return false;

        dbService.instantiateTestDatabase();
        return true;
    }

}
