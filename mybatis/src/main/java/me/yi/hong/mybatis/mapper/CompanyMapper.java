package me.yi.hong.mybatis.mapper;

import me.yi.hong.mybatis.entity.Company;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyMapper {
    Company findById(String id);
    List<Company> findList();
    List<Company> findListByCondition(Company company);
    void update(Company company);
    void delete(String id);
}
