package demo.eureka.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 做个是 config 模块
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaConfigClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaConfigClientApplication.class, args);
    }
}