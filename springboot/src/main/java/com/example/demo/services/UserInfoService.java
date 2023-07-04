package com.example.demo.services;

import com.example.demo.pojo.Chat;
import com.example.demo.pojo.User;
import com.example.demo.pojo.Relate;

import java.util.List;

public interface UserInfoService {
    //    更新用户信息
    public int updateUserInfo(User newInfo);
    //    通过id查询用户
    public User getInfoById(int id);
    //    通过邮箱查询用户
    public User getInfoByEmail(String email);

    public List<Chat> getChats(int id);
    //    添加好友
    public int addFriend(Relate newFriend);
    //    检查是否已经添加了好友
    public boolean isFriend(Relate friend);
    //    获取所有好友
    public List<Relate> getAllFriends(int userId);
}
