package com.esvarog.dekanat;

import com.esvarog.dekanat.security.DataInitializer;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DekanatApplication {

    private final DataInitializer dataInitializer;

    public DekanatApplication(DataInitializer dataInitializer) {
        this.dataInitializer = dataInitializer;
    }

    public static void main(String[] args) {
        SpringApplication.run(DekanatApplication.class, args);
    }

    @PostConstruct
    public void init() {
        this.dataInitializer.init();
    }

}
