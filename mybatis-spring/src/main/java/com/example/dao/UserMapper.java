package com.example.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
  @Select("SELECT * FROM tb_user")
  List<User> getUsers();
} 