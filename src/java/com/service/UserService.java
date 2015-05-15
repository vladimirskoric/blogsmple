/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.service;

import com.model.User;
import com.dao.UserDao;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import sqlexpression.*;

/**
 *
 * @author vladimir
 */

@Service
public class UserService {
 
    @Autowired(required = true)
    private UserDao userDao;
        
    public boolean isValidUser(String username, String password) throws SqlExpressionException, SQLException
    {
        return getUserDao().isValidUser(username, password);
    }
    
    public Iterable<User> getUsers() throws SqlExpressionException, SQLException
    {
        return getUserDao().getUsers();
    }

    /**
     * @return the userDao
     */
    public UserDao getUserDao() {
        return userDao;
    }

    /**
     * @param userDao the userDao to set
     */
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
