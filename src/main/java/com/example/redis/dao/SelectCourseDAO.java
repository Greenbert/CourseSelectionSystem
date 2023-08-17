package com.example.redis.dao;

import com.example.redis.bean.Course;
import com.example.redis.bean.CourseStudent;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SelectCourseDAO {

    @Select("select * from choose_courses_data")
    public List<CourseStudent> findAll();

    @Select("select * from choose_courses_data where stuid = #{id}")
    public List<CourseStudent> findBySid(String id);

    @Insert("insert into choose_courses_data(stuid,couid) values(#{stuid},#{couid})")
    public void insertT(CourseStudent courseStudent);

    @Delete("delete from choose_courses_data where stuid=#{stuid} and couid=#{couid}")
    public void deleteById(CourseStudent courseStudent);

    @Select("select count(*) from choose_courses_data where couid = #{couid}")
    public int selectCount(String couid);
//
//    @Update("update tb_user set name=#{name},sex=#{sex} where id=#{id}")
//    public void updateT(User user);

}
