package com.example.reto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// Los componentes viven en los paquetes de nivel superior domain, application e infrastructure.
// Se declaran explícitamente para que el escaneo de Spring los encuentre desde esta clase de arranque.
@SpringBootApplication(scanBasePackages = {"domain", "application", "infrastructure"})
@EntityScan(basePackages = "infrastructure.persistence")
@EnableJpaRepositories(basePackages = "infrastructure.persistence")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}