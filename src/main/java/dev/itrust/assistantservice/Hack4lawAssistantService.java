package dev.itrust.assistantservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"dev.itrust"})
@Slf4j
public class Hack4lawAssistantService {

    public static void main(String[] args) {
        SpringApplication.run(Hack4lawAssistantService.class, args);
    }

}
