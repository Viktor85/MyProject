package com.my.messages.service.impl;

import com.my.messages.dao.UserDao;
import com.my.messages.service.UserService;
import com.my.messages.model.Message;
import com.my.messages.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;


    public void createUser(User user) {

        userDao.addUser(user);

    }


    public List<User> getAllUsers() {

        return userDao.getAllUsers();
    }

    public void deleteUser(int id) {

        User user = userDao.getUserId(id);
        for (Message message : user.getMessages()) {
            message.setReceiver(null);
        }

        userDao.deleteUser(id);

    }

    public void updateUser(User user) {
        userDao.updateUser(user);

    }

    public User getUserId(int id) {

        return userDao.getUserId(id);
    }

    @Override
    public String getUserNameById(int id) {

        return userDao.getUserNameById(id);
    }

    @Override
    public int getUserIdByUserName(String userName) {
        return userDao.getUserIdByUserName(userName);
    }

}

