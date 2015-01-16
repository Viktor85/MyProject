package com.my.messages.dao;

import com.my.messages.model.User;

import java.util.List;

public interface UserDao {

    public void addUser(User user);
    public List<User> getAllUsers();
    public void deleteUser( int id) ;
    public void updateUser(User user) ;
    public User getUserId(int id) ;
    public User getUser(String userName);
    public String getUserNameById(int id);
    public int getUserIdByUserName(String userName);
}
