package tn.esprit.exam2024;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableScheduling
public class Exam2024Application {

    public static void main(String[] args) {
        SpringApplication.run(Exam2024Application.class, args);
    }

}
