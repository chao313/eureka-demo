package demo.eureka.hystrx.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaHystrixDashboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaHystrixDashboardApplication.class, args);
    }
}