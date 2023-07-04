package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//这个实体类表示会话
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chat {
    private  String word;
    private  String time;
    private  int sendId;
    private  int receiveId;
}
