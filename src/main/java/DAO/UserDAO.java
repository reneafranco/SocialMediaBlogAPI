package DAO;

import Model.User;
import Util.GetConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public List<User> userList(){
        List<User> userList = new ArrayList<>();

        try{
            Connection connection = GetConnection.getDataSource().getConnection();
            String sql = "Select * from User";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                User user = new User(resultSet.getInt("id"),resultSet.getString("username"), resultSet.getString("password"));
                userList.add(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return userList;

    }

    public User getUserById(int id){

        try {
            Connection connection = GetConnection.getDataSource().getConnection();
            String sql = " Select * from User Where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                return new User(resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return null;
    }

    public User insertUser(User user){

        try {
            Connection connection = GetConnection.getDataSource().getConnection();
            String sql = "Insert into User (username, password) VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if(resultSet.next()){
                int generatedId = (int) resultSet.getLong(1);
                return new User(generatedId, user.getUsername(), user.getPassword());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }


    public void UpdateUser(int id, User user){

        try {
            Connection connection = GetConnection.getDataSource().getConnection();
            String sql = "Update User set username = ?, password = ? Where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
