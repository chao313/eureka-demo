package demo.eureka.provider.controller.hystrix;

import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableHystrix//启用断路器
public class EnableHystrixConfig {
}
