package demo.eureka.hystrx.dashboard.config;

import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Configuration;

/**
 * 本模块是hystrix 的 dashboard
 * -> 只是提供解析 ip:port/actuator/hystrix.stream 接口为dashboard 而已!
 */
@Configuration
@EnableHystrixDashboard//其他 hystrix dashboard
public class EnableHystrixDashboardConfig {
}
