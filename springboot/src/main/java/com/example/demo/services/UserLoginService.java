package com.example.demo.services;

import com.example.demo.pojo.User;
import com.example.demo.pojo.Login;

import java.util.List;

public interface UserLoginService {
    public Boolean isLoginByEmail(String email);
    public List<User> queryAllByEmail(String email);

    public Boolean isLoginById(int id);
    public List<User> queryAllById(int id);

    public int login(User user);

    public int addUser(User user);
}
