package cn.hong.demo.springcloud.controller;

import cn.hong.demo.springcloud.config.BlackListConfig;
import cn.hong.demo.springcloud.config.WhiteListConfig;
import cn.hutool.core.map.MapUtil;
import jakarta.annotation.Resource;
import java.util.Map;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试 nacos 的动态配置等
 */
@Slf4j
@RequestMapping("hello")
@RestController
@RefreshScope
public class HelloController {

  @Resource
  WhiteListConfig whiteListConfig;
  @Resource
  BlackListConfig blackListConfig;

  @Value("${white.name}")
  private String name;

  @GetMapping("white_list")
  public Map<String, String> getName() {
    log.info("whiteLIstConfig - name: {}", name);
    log.info("whiteLIstConfig: {}", whiteListConfig);
    log.info("blackListConfig: {}", blackListConfig);
    return MapUtil.<String, String>builder()
        .put("whiteListConfig", whiteListConfig.getName())
        .put("blackListConfig", blackListConfig.getName()).build();
  }


}
