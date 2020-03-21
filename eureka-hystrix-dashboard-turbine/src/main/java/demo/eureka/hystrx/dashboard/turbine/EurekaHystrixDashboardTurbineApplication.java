package demo.eureka.hystrx.dashboard.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaHystrixDashboardTurbineApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaHystrixDashboardTurbineApplication.class, args);
    }
}