package com.example.redis.dao;

import com.example.redis.bean.City;
import com.example.redis.bean.Country;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CountryDAO {

    @Select("select * from country where Code = #{code}")
    public Country findByCode(String code);

    @Select("select * from country")
    public List<Country> findAll();
}
