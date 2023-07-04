package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    private int id;
    private String password = "";
    private String name = "";
    private String gender = "";
    private String region = "";
    private String avatar = "";
    private String email = "";
}
