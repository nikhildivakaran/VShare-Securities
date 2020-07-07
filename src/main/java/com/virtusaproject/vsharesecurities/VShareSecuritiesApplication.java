package com.virtusaproject.vsharesecurities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories("com.virtusaproject.vsharesecurities.database")
//@ComponentScan("com.virtusaproject.vsharesecurities.database")
//@EntityScan("com.virtusaproject.vsharesecurities.database")
public class VShareSecuritiesApplication {

    public static void main(String[] args) {
        SpringApplication.run(VShareSecuritiesApplication.class, args);
    }

}
