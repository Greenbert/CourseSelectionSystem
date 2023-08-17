package com.example.redis.dao;

import com.example.redis.bean.Login;
import lombok.extern.java.Log;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;



@Mapper
public interface loginDAO {
    @Select("select * from login where id = #{id} and pwd= #{pwd}")
    public Login login(Login login);
}
