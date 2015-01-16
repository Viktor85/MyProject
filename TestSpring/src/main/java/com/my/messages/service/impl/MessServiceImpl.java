
package com.my.messages.service.impl;


import com.my.messages.dao.MessageDao;
import com.my.messages.dao.UserDao;
import com.my.messages.service.MessageService;

import com.my.messages.model.Message;
import com.my.messages.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class MessServiceImpl implements MessageService {


    @Autowired
        private MessageDao messageDao;
    @Autowired
    private UserDao userDao;


    @Override
    public void addMessage(Message message) {

        User user = userDao.getUser(message.getNickname());


        message.setReceiver(user);
        message.setSender(userDao.getUser(SecurityContextHolder.getContext().getAuthentication().getName()));

        messageDao.addMessage(message);
    }

    @Override
    public List<Message> getAllIncomingMessage() {
    return   messageDao.getAllIncomingMessage() ;
    }

    @Override
    public List<Message> getAllSendingMessage()
    {
        return   messageDao.getAllSendingMessage( ) ;
    }

    @Override
    public void deleteMessage(int id) {

        messageDao.deleteMessage(id);
    }

    @Override
    public List<Message> getIncomingMessagesForUser(int userId) {
        return messageDao.getIncomingMessagesForUser(userId)  ;
    }

    @Override
    public List<Message> getSendingMessagesForUser(int userId) {
        return messageDao.getSendingMessagesForUser(userId)  ;
    }


}



