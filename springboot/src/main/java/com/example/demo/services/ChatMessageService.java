package com.example.demo.services;

import com.example.demo.pojo.ChatMessage;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ChatMessageService {

    List<ChatMessage> getChatHistory(Long sendUerId, Long receiveUserId);

    void saveChatMessage(ChatMessage chatMessage);

}