package com.example.redis.dao;

import com.example.redis.bean.Course;
import com.example.redis.bean.CourseStudent;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseDAO {
//    @Select("select * from selectcourse where id = #{id}")
//    public City findById(int id);
    @Select("select * from courses_data")
    public List<Course> findAll();

    @Select("select c.couid,name,xf,xs,capacity,d.left from choose_courses_data AS c,courses_data as d where stuid =#{id} and c.couid = d.couid")
    public List<Course> getCourseBySid(String id);

    @Select("select * from courses_data where couid not in(select c.couid from choose_courses_data AS c,courses_data as d where stuid =#{id} and c.couid = d.couid)")
    public List<Course> getNoCourseBySid(String id);

    @Insert("insert into courses_data values(#{couid},#{name},#{xf},#{xs},#{capacity},#{left})")
    public void insertT(Course course);

    @Delete("delete from courses_data where couid=#{id}")
    public void deleteById(String id);

    @Update("update courses_data set name=#{name},xf=#{xf},xs=#{xs},capacity=#{capacity} where couid=#{couid}")
    public void updateT(Course course);

    @Update("update courses_data as c set c.left=#{left} where couid=#{couid}")
    public void updateLeft(Course course);
}
