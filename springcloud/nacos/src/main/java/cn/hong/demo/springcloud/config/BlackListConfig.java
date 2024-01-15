package cn.hong.demo.springcloud.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 黑名单配置
 */
@Data
@Component
@ConfigurationProperties(prefix = "black")
public class BlackListConfig {

  private String name;
}
