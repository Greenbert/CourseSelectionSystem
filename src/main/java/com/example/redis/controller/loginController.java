package com.example.redis.controller;

import com.example.redis.bean.Login;
import com.example.redis.service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class loginController {
    @Autowired
    private loginService service;

    @RequestMapping("login")
    public Login login(String id,String pwd){
        Login l = new Login();
        l.setId(id);
        l.setPwd(pwd);
        return service.login(l);
    }
}
