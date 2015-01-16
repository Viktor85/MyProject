package com.my.messages.dao.impl;

import com.my.messages.dao.UserDao;
import com.my.messages.model.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public List<User> getAllUsers() {


        return (List<User>) sessionFactory.getCurrentSession().createQuery("from User ").list();
    }

    public void deleteUser(int id) {


           User user = (User)   sessionFactory.getCurrentSession().get(User.class, id);
            sessionFactory.getCurrentSession().delete(user);


        }


    public void updateUser(User user) {

        sessionFactory.getCurrentSession().saveOrUpdate(user);

    }

    @Override
    public User getUserId(int id) {



       User user = (User)   sessionFactory.getCurrentSession().get(User.class, id);



        return user;
    }

    public void add(User user) {

        sessionFactory.getCurrentSession().save(user);
    }

   public User getUser(String userName) {
        List<User> userList ;
        Query query =  sessionFactory.getCurrentSession().createQuery("from User u where u.userName = :userName");
        query.setParameter("userName", userName);
        userList = query.list();
        if (userList.size() > 0)
            return userList.get(0);
        else
            return null;
    }

    @Override
    public String getUserNameById(int id) {
        List<String> results;
        Query query = sessionFactory.getCurrentSession().createQuery(
                " select u.userName from User u where u.id = " + id);


         results = query.list();
        System.out.println("======== "+ results);
        if (results.size() > 0) {
            return results.get(0);
        }
        else
            return null;


    }

    @Override
    public int getUserIdByUserName(String userName) {
        List <Integer>results;

        Query query =sessionFactory.getCurrentSession().createQuery(
                " select u.id from User u where u.userName = " + userName);

        results = query.list();

        if (results.size() > 0) {
            return results.get(0);
        }
        else
            return Integer.parseInt(null);
    }
}


