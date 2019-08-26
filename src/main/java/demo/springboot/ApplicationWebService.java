package demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "demo.springboot")
public class ApplicationWebService {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationWebService.class, args);
    }
}
