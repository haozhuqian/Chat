package com.example.demo.services;

import com.example.demo.mapper.ChatMessageMapper;
import com.example.demo.pojo.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ChatMessageServiceImpl implements ChatMessageService {
    @Autowired
    private ChatMessageMapper chatMessageMapper;


    @Override
    public List<Message> getChatHistory(int sendId, int receiveId) {
        return chatMessageMapper.getChatHistory(sendId, receiveId);
    }

    @Override
    @Transactional
    public void saveChatMessage(Message message) {
        chatMessageMapper.insertChatMessage(message);
    }
}