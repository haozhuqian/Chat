package com.example.demo.controller;

import com.example.demo.pojo.ChatMessage;
import com.example.demo.services.ChatMessageServiceImpl;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.*;
import com.example.demo.webSocket.MyWebSocket;
import java.util.List;

@RestController
@RequestMapping("/chat")
@CrossOrigin
public class ChatController {

  private final ChatMessageServiceImpl chatMessageServiceImpl;

  public ChatController(ChatMessageServiceImpl chatMessageServiceImpl) {
    this.chatMessageServiceImpl = chatMessageServiceImpl;
  }

  @GetMapping("/getChatHistory")
  public List<ChatMessage> getChatHistory(@RequestParam("sendUserId") Long sendUserId, @RequestParam("receiveUserId") Long receiveUserId) {
    return chatMessageServiceImpl.getChatHistory(sendUserId, receiveUserId);
  }

  @MessageMapping("/chat/{receiverId}")
  public void onMessage(@Payload ChatMessage chatMessage) {
    // 发送消息给接收者
//    MyWebSocket.sendMessage(chatMessage);
    // 保存聊天消息
    chatMessageServiceImpl.saveChatMessage(chatMessage);

  }

}