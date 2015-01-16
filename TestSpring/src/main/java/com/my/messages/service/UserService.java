package com.my.messages.service;


import com.my.messages.model.User;

import java.util.List;

public interface UserService {

    public void createUser(User user);
    public List<User> getAllUsers();
    public void deleteUser( int id) ;
    public void updateUser( User user) ;
    public User getUserId(int id);
    public String getUserNameById(int id);
    public int getUserIdByUserName(String userName);




}


