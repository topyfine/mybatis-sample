package com.example.mybatisspringboot.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from tb_user")
    List<User> selectUsers();

    @Insert("insert into tb_user(username) value(#{username})")
    int insertUser(User user);
}
