package me.yi.hong.mybatis;

import me.yi.hong.mybatis.mapper.CompanyMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisApplicationTests {

    @Autowired
    CompanyMapper mapper;

    @Test
    void contextLoads() {
        System.out.println(mapper.findList());
    }

}
