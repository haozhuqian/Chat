package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//这个实体类表示在聊天的好友列表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chat {
    private  String name;
    private  String avatar;
    private  String lastWord;
    private  String lastTime;
    private  int userId;
}
