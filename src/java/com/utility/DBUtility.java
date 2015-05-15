/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utility;

import java.sql.Connection;
import sqlexpression.DatabaseManager;
import sqlexpression.SqlDriver;

/**
 *
 * @author ryuzaki
 */
public class DBUtility {
    
    private static Connection _connection;
    public static Connection getConnection()
    {
        if(_connection == null)
        {
            DatabaseManager.start(SqlDriver.Derby, "localhost", 1527, "MyDB", "app", "app");
            _connection = DatabaseManager.getConnection();
        }
        
        return _connection;
    }
}
