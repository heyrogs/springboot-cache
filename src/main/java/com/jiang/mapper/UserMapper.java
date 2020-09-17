package com.jiang.mapper;

import com.jiang.entity.dto.UserDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author shijiang.luo
 * @description
 * @date 2020-09-16 22:45
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE id = #{id}")
    UserDTO getUserById(Integer id);

    @Update("UPDATE user set name=#{name},age=#{age} WHERE id=#{id}")
    Integer updateUser(UserDTO user);

    @Delete("DELETE FROM user WHERE id=#{id}")
    Integer deleteUserById(Integer id);

    @Insert("INSERT INTO user(name, age) values (#{name}, #{age})")
    Integer insertUser(UserDTO user);

    @Select("SELECT * FROM user")
    List<UserDTO> list();

}