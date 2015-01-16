package com.my.messages.service;


import com.my.messages.model.Message;

import java.util.List;



public interface MessageService {
    public void addMessage(Message message);
    public List<Message> getAllIncomingMessage();
    public List<Message> getAllSendingMessage();
    public void deleteMessage( int id) ;
    public List<Message> getIncomingMessagesForUser(int userId);
    public List<Message> getSendingMessagesForUser(int userId);
}
