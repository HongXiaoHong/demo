package me.yi.hong.mybatis.service;

import me.yi.hong.mybatis.entity.Company;
import me.yi.hong.mybatis.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class CompanyService {

    @Autowired
    CompanyMapper mapper;

    public Company findCompany(String id) {
        return mapper.findById(id);
    }
}
