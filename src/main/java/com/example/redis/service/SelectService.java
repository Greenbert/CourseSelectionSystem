package com.example.redis.service;


import com.example.redis.bean.Course;
import com.example.redis.bean.CourseStudent;
import com.example.redis.dao.CourseDAO;
import com.example.redis.dao.SelectCourseDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SelectService {
    @Resource
    private SelectCourseDAO dao;

//    @Cacheable("citylist")
    public List<CourseStudent> findAll(){
        return dao.findAll();
    }

    public List<CourseStudent> findBySid(String id){
        return dao.findBySid(id);
    }

    public void insertT(CourseStudent courseStudent){
        dao.insertT(courseStudent);
    }

    public void deleteById(CourseStudent courseStudent){
        dao.deleteById(courseStudent);
    }

    public int selectCount(String couid){
        return dao.selectCount(couid);
    }
}
