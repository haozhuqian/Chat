package com.example.demo.controller;

import com.example.demo.pojo.Message;
import com.example.demo.services.ChatMessageServiceImpl;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.*;

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
  public List<Message> getChatHistory(@RequestParam("sendId") int sendId, @RequestParam("receiveId") int receiveId) {
    return chatMessageServiceImpl.getChatHistory(sendId, receiveId);
  }

  @MessageMapping("/chat/{receiverId}")
  public void onMessage(@Payload Message message) {
    // 发送消息给接收者
//    MyWebSocket.sendMessage(chatMessage);
    // 保存聊天消息
    chatMessageServiceImpl.saveChatMessage(message);

  }

}