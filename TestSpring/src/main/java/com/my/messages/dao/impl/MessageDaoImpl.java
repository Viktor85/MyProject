

package com.my.messages.dao.impl;


import com.my.messages.dao.MessageDao;
import com.my.messages.model.Message;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageDaoImpl implements MessageDao {



    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addMessage(Message message) {


        sessionFactory.getCurrentSession().save(message);



    }
    @Override
    public List<Message> getAllIncomingMessage() {


        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Message.class);

        criteria.add(Restrictions.eq("receiver.id",1));

        return (List<Message>) criteria.list();
    }

    public List<Message> getAllSendingMessage() {


        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Message.class);



        criteria.add(Restrictions.eq("sender.id", 1));

        return (List<Message>) criteria.list();
    }

    public void deleteMessage(int id) {


        Message message = (Message)   sessionFactory.getCurrentSession().get(Message.class, id);
        sessionFactory.getCurrentSession().delete(message);

    }

    @Override
    public List<Message> getIncomingMessagesForUser(int userId) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Message.class);
        criteria.add(Restrictions.eq("receiver.id", userId));

        return (List<Message>) criteria.list();
    }

    @Override
    public List<Message> getSendingMessagesForUser(int userId) {
      Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Message.class);
        criteria.add(Restrictions.eq("sender.id",userId));

        return (List<Message>) criteria.list();
    }
}



