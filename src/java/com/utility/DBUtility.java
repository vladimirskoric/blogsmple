/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utility;

import java.sql.Connection;
import org.springframework.stereotype.Component;
import sqlexpression.DatabaseManager;
import sqlexpression.SqlDriver;
import sqlexpression.SqlExpressionException;

/**
 *
 * @author ryuzaki
 */
@Component
public class DBUtility {
    
    private Connection _connection;
    public Connection getConnection() throws SqlExpressionException
    {
        if(_connection == null)
        {
            DatabaseManager.start(SqlDriver.Derby, "localhost", 1527, "MyDB", "app", "app");
            _connection = DatabaseManager.getConnection();
            
            if(_connection == null)
                throw new SqlExpressionException("Check database server. Could be that it's not running.");
        }
        
        return _connection;
    }
}
