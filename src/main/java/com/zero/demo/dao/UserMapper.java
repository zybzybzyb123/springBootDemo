package com.zero.demo.dao;

import com.zero.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE id = #{id}")
    User getUserById(int id);

    @Insert("INSERT INTO user(name, create_time, update_time) VALUES(#{name}, #{createTime}, #{updateTime})")
    int createUser(String name, long createTime, long updateTime);
}