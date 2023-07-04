package com.example.demo.webSocket;


import com.alibaba.fastjson.JSON;
import com.example.demo.pojo.ChatMessage;
import com.example.demo.services.ChatMessageService;
import com.example.demo.services.UserInfoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.websocket.Session;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/websocket/{nickname}")
@Service
@Slf4j
public class MyWebSocket {

    private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<MyWebSocket>();

    private Session session;


    private static ChatMessageService chatMessageService;

    private static UserInfoService userInfoService;
    @Autowired
    public void setChatMessageService(ChatMessageService chatMessageService) {
        MyWebSocket.chatMessageService = chatMessageService;
    }
    @Autowired
    public void setUserInfoServicesI(UserInfoService userInfoService) {
        MyWebSocket.userInfoService = userInfoService;
    }

    @OnOpen
    public void onOpen(Session session, @PathParam("nickname") String nickname) {
        this.session = session;
        webSocketSet.add(this);
        System.out.println("有新连接加入:" + nickname + ",当前在线人数为：" + webSocketSet.size());
        this.session.getAsyncRemote().sendText("恭喜您成功连接上WebSocket-->当前在线人数为：" + webSocketSet.size());
    }

    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        System.out.println("有一连接关闭！当前在线人数为：" + webSocketSet.size());
    }

    @OnMessage
    public void onMessage(String message, Session session, @PathParam("nickname") String nickname) {
        ObjectMapper mapper = new ObjectMapper();
        ChatMessage chatMessage;
        try {
            chatMessage = mapper.readValue(message, ChatMessage.class);
            log.info(JSON.toJSONString(chatMessage));
            SimpleDateFormat format  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String sendTime = format.format(date);
            chatMessage.setSendTime(sendTime);
            chatMessageService.saveChatMessage(chatMessage); // 将ChatMessage对象存入数据库中
            broadcast(message);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("来自客户端的消息-->" + nickname + ": " + message);
        // 群发消息
        broadcast(message);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

    public void broadcast(String message) {
        for (MyWebSocket item : webSocketSet) {
            item.session.getAsyncRemote().sendText(message);
        }
    }

}