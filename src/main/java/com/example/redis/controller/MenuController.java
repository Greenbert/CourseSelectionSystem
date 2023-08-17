package com.example.redis.controller;

import com.example.redis.bean.City;
import com.example.redis.bean.Country;
import com.example.redis.service.CityService;
import com.example.redis.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("menu")
public class MenuController {
    @Autowired
    private CountryService countryService;

    @Autowired
    private CityService cityService;


    @RequestMapping("/findByCode")
    public List<City> findByCode(String code){
        return cityService.findByCode(code);
    }

    @RequestMapping("/findAllCountry")
    public List<Country> findAll(){
//        redisTemplate.opsForValue().set("num","123");
        return countryService.findAll();
    }
}
