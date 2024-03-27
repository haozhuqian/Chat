package com.example.demo.services;

import com.example.demo.mapper.UserInfoMapper;
import com.example.demo.pojo.Chat;
import com.example.demo.pojo.User;
import com.example.demo.pojo.Relate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpI implements UserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;
    //    更新用户信息
    @Override
    public List<Relate> getAllFriends(int id){return  userInfoMapper.getAllFriends(id);};
    //    通过id查询用户
    @Override
    public User getInfoById(int id){
        return userInfoMapper.getInfoById(id);
    }
    //    通过邮箱查询用户
    @Override
    public User getInfoByEmail(String email){ return userInfoMapper.getInfoByEmail(email); }
    @Override
    public List<Chat> getChats(int id){ return userInfoMapper.getChats(id);}
    @Override
    public boolean hasChats(Chat chat){ return userInfoMapper.hasChats(chat); }
    @Override
    public int setChats(Chat chat){ return userInfoMapper.setChats(chat); };
    //    添加好友
    @Override
    public int addFriend(Relate newFriend){return  userInfoMapper.addFriend(newFriend);};
    //    检查是否已经添加了好友
    @Override
    public boolean isFriend(Relate friend){ return userInfoMapper.isFriend(friend); };

    @Override
    public int updateUserInfo(User newInfo){
        return userInfoMapper.updateUserInfo(newInfo);
    }
    //    获取所有好友
}
