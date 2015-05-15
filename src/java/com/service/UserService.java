/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.service;

import com.model.User;
import com.dao.UserDao;
import java.sql.SQLException;


import sqlexpression.*;

/**
 *
 * @author vladimir
 */
public class UserService {
 
    private UserDao userDao;
    
    public UserService()
    {
      userDao = new UserDao();
    }
    
    public boolean isValidUser(String username, String password) throws SqlExpressionException, SQLException
    {
        return userDao.isValidUser(username, password);
    }
    
    public Iterable<User> getUsers() throws SqlExpressionException, SQLException
    {
        return userDao.getUsers();
    }
}
