package com.example.redis.controller;


import com.example.redis.bean.Course;
import com.example.redis.bean.CourseStudent;
import com.example.redis.service.CourseService;
import com.example.redis.service.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService service;

    @RequestMapping("/findAll")
    public List<Course> findAll(){
        return service.findAll();
    }

    @RequestMapping("/getcourse")
    public List<Course> getCourseBySid(String id){
        return service.getCourseBySid(id);
    }

    @RequestMapping("/getnocourse")
    public List<Course> getNoCourseBySid(String id){
        return service.getNoCourseBySid(id);
    }

    @RequestMapping("/insertcourse")
    public void insertT(String couid,String name,String xf,String xs,String capacity,String left){
        Course course = new Course();
        course.setCouid(couid);
        course.setName(name);
        course.setXf(Integer.parseInt(xf));
        course.setXs(Integer.parseInt(xs));
        course.setCapacity(Integer.parseInt(capacity));
        course.setLeft(Integer.parseInt(left));
        service.insertT(course);
    }

    @RequestMapping("/deletecourse")
    public void deleteById(String couid){
        service.deleteById(couid);
    }

    @RequestMapping("/updatecourse")
    public void updateT(String couid,String name,String xf,String xs,String capacity){
        Course course = new Course();
        course.setCouid(couid);
        course.setName(name);
        course.setXf(Integer.parseInt(xf));
        course.setXs(Integer.parseInt(xs));
        course.setCapacity(Integer.parseInt(capacity));
        service.updateT(course);
    }

    @RequestMapping("/updateLeft")
    public void updateLeft(String couid, String left){
        Course course = new Course();
        course.setCouid(couid);
        course.setLeft(Integer.parseInt(left));
        service.updateLeft(course);
    }

}
