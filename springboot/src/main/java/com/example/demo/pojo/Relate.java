package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//这个实体类表示好友列表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Relate {
    private int sendId;
    private int receiveId;
    public void exchangeId(){
        int cup=this.sendId;
        this.sendId=this.receiveId;
        this.receiveId=cup;
    }

}
