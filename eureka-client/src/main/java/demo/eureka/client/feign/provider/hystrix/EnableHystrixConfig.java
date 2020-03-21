package demo.eureka.client.feign.provider.hystrix;

import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableHystrix//启用断路器(在feigm调用的程序中，其实不需要，但是需要开放 hystrix.stream)
public class EnableHystrixConfig {
}
