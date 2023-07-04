package com.example.demo.services;

import com.example.demo.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginException {
    private boolean state;
    private String fail = "";
    private User Success;
    public UserLoginException setSuccess(User user){
        this.state = false;
        this.Success = user;
        return this;
    }
    public UserLoginException setFail(String why){
        this.state = true;
        this.fail = why;
        return this;
    }

}
