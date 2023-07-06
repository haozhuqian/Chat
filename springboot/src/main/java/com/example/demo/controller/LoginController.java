package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.pojo.Login;
import com.example.demo.services.UserLoginException;
import com.example.demo.services.UserLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class LoginController {
    @Autowired
    UserLoginServiceImpl loginS;

    @PostMapping("/toLogin")
    //登录
    public UserLoginException toLogin(@RequestBody User userLogin ){
        UserLoginException res = new UserLoginException();
        if(!loginS.isLoginByEmail(userLogin.getEmail())){
            List<User> loginUser = loginS.queryAllByEmail(userLogin.getEmail());
            if(loginUser != null && !loginUser.isEmpty()){
                User user = loginUser.get(0);
                if(user.getPassword().equals(userLogin.getPassword())){
                    loginS.login(user);
                    return res.setSuccess(user);
                }
                return res.setFail("密码或邮箱错误");
            }
            return res.setFail("您未注册");
        }
        res.setSuccess(loginS.queryAllByEmail(userLogin.getEmail()).get(0));
        return res.setFail("你已登录");
    }

    @PostMapping("/Register")
    //注册
    public String toRegisterSuccess( @RequestBody User user){
        
        //将账号密码加入到数据库中
        loginS.addUser(user.getEmail(), user.getPassword());
        return "RegisterSuccess";
    }
}
