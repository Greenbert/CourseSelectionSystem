package com.example.redis.service;

import com.example.redis.bean.Login;
import com.example.redis.dao.loginDAO;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class loginService {
    @Resource
    private loginDAO dao;

    @Cacheable("login")
    public Login login(Login login){
        return dao.login(login);
    }

}
