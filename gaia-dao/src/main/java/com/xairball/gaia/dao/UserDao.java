package com.xairball.gaia.dao;

import org.apache.ibatis.annotations.Mapper;

import com.xairball.gaia.model.User;
@Mapper
public interface UserDao {
	User selectByUsername(String username);
}
