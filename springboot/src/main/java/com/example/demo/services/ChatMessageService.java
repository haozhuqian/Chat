package com.example.demo.services;

import com.example.demo.pojo.Message;

import java.util.List;

public interface ChatMessageService {

    List<Message> getChatHistory(int sendId, int receiveId);

    void saveChatMessage(Message message);

}