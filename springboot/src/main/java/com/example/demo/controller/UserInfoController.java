package com.example.demo.controller;

import com.example.demo.pojo.Chat;
import com.example.demo.pojo.User;
import com.example.demo.pojo.Relate;
import com.example.demo.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.demo.webSocket.MyWebSocket.userInfoService;

@RestController
@RequestMapping
public class UserInfoController {
    @Autowired
    UserInfoService InfoS;

    @PostMapping("/updateUserInfo")
    public String updateUserInfo(@RequestBody User newInfo){
        InfoS.updateUserInfo(newInfo);
        System.out.println(newInfo.toString());
        return "success";
    }
    @GetMapping("/getAllFriends")
    public List<Chat> getAllFriends(@RequestParam("id") int id){
        List<Chat> friendList= InfoS.getChats(id);
        System.out.println(friendList.toString());
        return friendList;
    }
    @GetMapping("/getUserInfoById")
    public User getUserInfoById(@RequestParam("id") int id){
        return InfoS.getInfoById(id);
    }
    @GetMapping("/getUserInfoByEmail")
    public User getUserInfoByEmail(@RequestParam("email") String email){
        return InfoS.getInfoByEmail(email);
    }
    @PostMapping("/addFriend")
    public int addFriend(@RequestBody Relate userRelate){
        if(!InfoS.isFriend(userRelate){
            InfoS.addFriend(userRelate);
        }
        return 1;
    }
}
