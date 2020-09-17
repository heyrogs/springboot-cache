package com.jiang.controller;

import com.jiang.entity.vo.UserVO;
import com.jiang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shijiang.luo
 * @description
 * @date 2020-09-16 22:56
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("user/{id}")
    public UserVO user(@PathVariable Integer id){

        return userService.getUser(id);
    }

    @GetMapping("user/edit")
    public UserVO updateUser(UserVO userVO){

        return userService.updateUser(userVO);
    }

    @DeleteMapping("user/delete/{id}")
    public String deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return "success";
    }

}