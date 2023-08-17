package com.example.redis.controller;


import com.example.redis.KafkaMessageProducer;
import com.example.redis.bean.Course;
import com.example.redis.bean.CourseStudent;
import com.example.redis.service.CourseService;
import com.example.redis.service.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("select")
public class SelectController {
    @Autowired
    private SelectService service;

    @Autowired
    KafkaMessageProducer kafkaMessageProducer;

    @Autowired
    private CourseService handleCourse;

    @RequestMapping("/findAll")
    public List<CourseStudent> findAll(){
        return service.findAll();
    }

    @RequestMapping("/findBySid")
    public List<CourseStudent> findBySid(String stuid){
        return service.findBySid(stuid);
    }

    @RequestMapping("/insertT")
    public void insertT(String stuid,String couid,String left){
        kafkaMessageProducer.send(stuid,couid);
        int tmp = Integer.parseInt(left) - 1;
        Course course = new Course();
        course.setCouid(couid);
        course.setLeft(tmp);

        CourseStudent courseStudent = new CourseStudent();
        courseStudent.setStuid(stuid);
        courseStudent.setCouid(couid);
        service.insertT(courseStudent);

        handleCourse.updateLeft(course);


    }

    @RequestMapping("/deleteById")
    public void deleteById(String stuid,String couid,String left){
        int tmp = Integer.parseInt(left) + 1;
        Course course = new Course();
        course.setCouid(couid);
        course.setLeft(tmp);

        CourseStudent courseStudent = new CourseStudent();
        courseStudent.setStuid(stuid);
        courseStudent.setCouid(couid);
        service.deleteById(courseStudent);
        
        handleCourse.updateLeft(course);
    }

    @RequestMapping("/selectcount")
    public int selectCount(String couid){
        return service.selectCount(couid);
    }
}
