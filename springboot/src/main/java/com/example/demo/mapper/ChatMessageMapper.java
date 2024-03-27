package com.example.demo.mapper;

import com.example.demo.pojo.Message;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface ChatMessageMapper {

    List<Message> getChatHistory(int sendId, int receiveId);

    void insertChatMessage(Message message);

}