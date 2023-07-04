package com.example.demo.services;

import com.alibaba.fastjson.JSON;
import com.example.demo.mapper.ChatMessageMapper;
import com.example.demo.pojo.ChatMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@Slf4j
public class ChatMessageServiceImpl implements ChatMessageService {
    @Autowired
    private ChatMessageMapper chatMessageMapper;


    @Override
    public List<ChatMessage> getChatHistory(Long sendUserId, Long receiveUserId) {
        return chatMessageMapper.getChatHistory(sendUserId, receiveUserId);
    }

    @Override
    @Transactional
    public void saveChatMessage(ChatMessage chatMessage) {
        chatMessageMapper.insertChatMessage(chatMessage);
    }
}