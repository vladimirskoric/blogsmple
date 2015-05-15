/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sqlexpression.OperationEnum;
import sqlexpression.SelectExpression;
import sqlexpression.SqlExpressionException;
import com.model.User;
import com.utility.DBUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ryuzaki
 */
@Repository
public class UserDao {
    
    @Autowired
    private DBUtility dbUtil;
    
    public Iterable<User> getUsers() throws SqlExpressionException, SQLException
    {
        SelectExpression exp = new SelectExpression(dbUtil.getConnection(),"LOGIN");
        ResultSet result = exp.execute();
        
        ArrayList<User> users = new ArrayList<>();
        while(result.next())
        {
            User user = new User();
            user.setUsername(result.getString("USERNAME"));
            user.setPassword(result.getString("PASSWORD"));
            users.add(user);
        }
        
        return users;
    }
    
    public boolean isValidUser(String username, String password) throws SqlExpressionException, SQLException
    {
        SelectExpression exp = new SelectExpression(dbUtil.getConnection(),"LOGIN");
        exp.where("USERNAME", OperationEnum.Equal, username);
        exp.where("PASSWORD", OperationEnum.Equal, password);
        ResultSet result =exp.execute();
        
        return result.next();
    }
}
