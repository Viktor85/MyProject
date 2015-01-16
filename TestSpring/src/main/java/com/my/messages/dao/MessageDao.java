package com.my.messages.dao;




import com.my.messages.model.Message;

import java.util.List;

public interface MessageDao {
    public void addMessage(Message message);
    public List<Message> getAllIncomingMessage();
    public List<Message> getAllSendingMessage();
    public List<Message> getIncomingMessagesForUser(int userId);
    public List<Message> getSendingMessagesForUser(int userId);
    public void deleteMessage( int id) ;


}
