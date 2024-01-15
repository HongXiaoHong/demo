package cn.hong.demo.springcloud.config;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class WhiteLIstConfigTest {

  @Autowired
  WhiteListConfig whiteLIstConfig;

  @Test
  void getName() {
    log.info("whiteLIstConfig: {}", whiteLIstConfig);
  }
}