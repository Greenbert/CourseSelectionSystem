package com.example.redis.service;

import com.example.redis.bean.City;
import com.example.redis.dao.CityDAO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CityService {
    @Resource
    private CityDAO dao;

    @Cacheable("city")
    public City findById(int id){
        return dao.findById(id);
    }

    @Cacheable("cityCodeList")
    public List<City> findByCode(String code){
        return dao.findByCode(code);
    }
    @Cacheable("citylist")
    public List<City> findAll(){
        return dao.findAll();
    }
}
