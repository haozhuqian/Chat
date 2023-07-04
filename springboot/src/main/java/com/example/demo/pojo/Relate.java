package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//这个实体类表示好友列表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Relate {
    private String sendId;
    private  String receiveId;
}
