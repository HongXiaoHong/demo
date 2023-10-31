package me.yi.hong.mybatis;

import java.util.Random;
import me.yi.hong.mybatis.entity.Company;
import me.yi.hong.mybatis.mapper.CompanyMapper;
import me.yi.hong.mybatis.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootTest
class MybatisApplicationTests {

    @Autowired
    CompanyMapper mapper;
    @Autowired
    CompanyService service;

    @Test
    void contextLoads() {
//        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDate.now()));
//        System.out.println(DateTimeFormatter.ofPattern("yyyy|MM|dd").parse("2023|09|30"));
//        System.out.println(mapper.findList());
//        System.out.println(mapper.findById("1"));
//        System.out.println(mapper.findById("1"));
        System.out.println(service.findCompany("1"));
        System.out.println(service.findCompany("1"));
        System.out.println(service.findCompany("1"));
//        Company company = new Company();
//        company.setAddress("gz");
//        company.setId((int) System.currentTimeMillis());
//        company.setAge("22");
//        company.setName("hong" + new Random().nextInt(100));
//        service.insert(company);
    }

}
