package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatItem{
    private int id;
    private String name = "";
    private String time;
    private String word;
    private String avatar = "";
}
