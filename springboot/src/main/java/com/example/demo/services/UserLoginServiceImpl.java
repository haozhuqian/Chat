package com.example.demo.services;

import com.example.demo.mapper.UserLoginMapper;
import com.example.demo.pojo.Login;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    UserLoginMapper userLoginMapper;
    @Override
    public Boolean isLoginByEmail(String email) { return userLoginMapper.isLoginByEmail(email); }
    @Override
    public Boolean isLoginById(int id) { return userLoginMapper.isLoginById(id); }
    @Override
    public List<User> queryAllById(int id) { return userLoginMapper.queryAllById(id); }
    @Override
    public List<User> queryAllByEmail(String email) { return userLoginMapper.queryAllByEmail(email); }
    @Override
    public int login(User user) { return userLoginMapper.login(user); }
    @Override
    public int addUser(User user){return  userLoginMapper.addUser(user);}
}
