package com.example.redis.service;


import com.example.redis.bean.Course;
import com.example.redis.dao.CourseDAO;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CourseService {
    @Resource
    private CourseDAO dao;

//    @Cacheable("city")
//    public City findById(int id){
//        return dao.findById(id);
//    }
//
//    @Cacheable("cityCodeList")
//    public List<City> findByCode(String code){
//        return dao.findByCode(code);
//    }
    @Cacheable(value = "courList", unless = "#result.size() == 0") //后面result是关键
    public List<Course> findAll(){
        return dao.findAll();
    }

    public List<Course> getCourseBySid(String id){
        return dao.getCourseBySid(id);
    }

    public List<Course> getNoCourseBySid(String id){
        return dao.getNoCourseBySid(id);
    }

    @Caching(
            put = {@CachePut(value = "courCache", key = "#course.couid")},
            evict = {@CacheEvict(value = "courList", allEntries = true)}
    )
    public Course insertT(Course course){
        dao.insertT(course);
        return course;
    }

    @Caching(
            evict = {
                    @CacheEvict(value = "courCache", key = "#id"),
                    @CacheEvict(value = "courList", allEntries = true)
            }
    )
    public void deleteById(String id){
        dao.deleteById(id);
    }

    @Caching(
            put = {@CachePut(value = "courCache", key = "#course.couid")},
            evict = {@CacheEvict(value = "courList", allEntries = true)}
    )
    public Course updateT(Course course){
        dao.updateT(course);
        return course;
    }

    public void updateLeft(Course course){
        dao.updateLeft(course);
    }
}
