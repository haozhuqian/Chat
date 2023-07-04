package com.example.demo.mapper;

import com.example.demo.pojo.ChatMessage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface ChatMessageMapper {

    List<ChatMessage> getChatHistory(Long sendUserId, Long receiveUserId);

    void insertChatMessage(ChatMessage chatMessage);

}