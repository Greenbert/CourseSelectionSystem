package com.example.redis.service;

import com.example.redis.bean.City;
import com.example.redis.bean.Country;
import com.example.redis.dao.CityDAO;
import com.example.redis.dao.CountryDAO;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CountryService {

    @Resource
    private CountryDAO dao;

    @Cacheable("Country")
    public Country findByCode(String code){
        return dao.findByCode(code);
    }
    @Cacheable("Countrylist")
    public List<Country> findAll(){
        return dao.findAll();
    }
}
