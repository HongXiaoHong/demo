package cn.hong.demo.springcloud.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 白名单配置
 */
@Data
@Component
@RefreshScope
public class WhiteListConfig {

  @Value("${white.name}")
  private String name;
}
