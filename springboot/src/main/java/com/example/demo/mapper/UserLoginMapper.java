package com.example.demo.mapper;

import com.example.demo.pojo.User;
import com.example.demo.pojo.Login;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserLoginMapper {
    public Boolean isLoginByEmail(String email);
    public List<User> queryAllByEmail(String email);
    public Boolean isLoginById(int id);
    public List<User> queryAllById(int id);
    public int login(User user);
    public int addUser(String email,String password);
}
