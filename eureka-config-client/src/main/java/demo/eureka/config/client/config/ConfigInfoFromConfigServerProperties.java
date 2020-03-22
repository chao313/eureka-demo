package demo.eureka.config.client.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @description :这个配置信息是从配置中心 config-sever获取的
 * demo:
 *   eureka:
 *     config:
 *       client:
 *         info: i am dev
 */
@Data
@Component
@ConfigurationProperties(prefix = "demo.eureka.config.client")
public class ConfigInfoFromConfigServerProperties {
    private String info;
}
