package com.example.demo.controller;

import com.example.demo.pojo.Chat;
import com.example.demo.pojo.User;
import com.example.demo.pojo.Relate;
import com.example.demo.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


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
    @GetMapping("/getChats")
    public List<Chat> getChats(@RequestParam("id") int id){
        List<Chat> ChatList= InfoS.getChats(id);
        return ChatList;
    }
    @PostMapping("/setChats")
    public int setChats(@RequestBody Chat chat){
        InfoS.setChats(chat);
        return 1;
    }
    @GetMapping("/getAllFriends")
    public List<User> getAllFriends(@RequestParam("id") int id){
        List<Relate> RelateList= InfoS.getAllFriends(id);
        List<User> friendList = new ArrayList<User>();
        for (Relate i : RelateList) {
            friendList.add(InfoS.getInfoById(i.getReceiveId()));
        }
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
        if(!InfoS.isFriend(userRelate)){
            InfoS.addFriend(userRelate);
            userRelate.exchangeId();
            InfoS.addFriend(userRelate);
        }
        return 1;
    }
    @PostMapping("/isFriend")
    public boolean isFriend(@RequestBody Relate rel){
        return InfoS.isFriend(rel);
    }


}
