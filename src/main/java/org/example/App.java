package org.example;

import DAO.MessageDAO;
import DAO.UserDAO;
import Model.Message;
import Model.User;
import Service.MessageServices;
import Service.UserServices;
import Util.GetConnection;
import io.javalin.Javalin;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class App 
{
    public static void main( String[] args )
    {

        dbSetUp();
        Javalin app = Javalin.start(7000);
    }

    public static void dbSetUp(){
        try {
            Connection connection = GetConnection.getDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
