package com.example.demo.webSocket;

public class SocketMsg {
    private int type;   //聊天类型0：群聊，1：单聊.
    private String fromUser;//发送者.
    private String toUser;//接受者.
    private String msg;//消息
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public String getFromUser() {
        return fromUser;
    }
    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }
    public String getToUser() {
        return toUser;
    }
    public void setToUser(String toUser) {
        this.toUser = toUser;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
