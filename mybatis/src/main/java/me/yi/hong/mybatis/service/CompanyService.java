package me.yi.hong.mybatis.service;

import me.yi.hong.mybatis.entity.Company;
import me.yi.hong.mybatis.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
@Service
public class CompanyService {

    @Autowired
    CompanyMapper mapper;

    @Transactional
    public Company findCompany(String id) {
        return mapper.findById(id);
    }
    @Transactional
    public void insert(Company company) {
        mapper.insert(company);
    }

}
