package com.example.redis.dao;

import com.example.redis.bean.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Mapper
public interface CityDAO {
    @Select("select * from city where id = #{id}")
    public City findById(int id);

    @Select("select * from city")
    public List<City> findAll();

    @Select("select * from city where CountryCode = #{countryCode}")
    public List<City> findByCode(String countryCode);
}
