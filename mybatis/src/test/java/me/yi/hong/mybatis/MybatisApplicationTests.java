package me.yi.hong.mybatis;

import me.yi.hong.mybatis.mapper.CompanyMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootTest
class MybatisApplicationTests {

    @Autowired
    CompanyMapper mapper;

    @Test
    void contextLoads() {
        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDate.now()));
        System.out.println(DateTimeFormatter.ofPattern("yyyy|MM|dd").parse("2023|09|30"));
        System.out.println(mapper.findList());
    }

}
