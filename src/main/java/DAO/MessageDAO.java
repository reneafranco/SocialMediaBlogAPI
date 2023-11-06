package DAO;

import Model.Message;
import Model.User;
import Util.GetConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageDAO {

    public List<Message> MessageList(){
        List<Message> messageList = new ArrayList<>();

        try{
            Connection connection = GetConnection.getDataSource().getConnection();
            String sql = "Select * from messages";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Message message = new Message(resultSet.getString("content"), resultSet.getInt("created_by"), resultSet.getLong("created_at"));
                messageList.add(message);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return messageList;

    }

    public Message getMessageBiId(int id){

        try {
            Connection connection = GetConnection.getDataSource().getConnection();
            String sql = "Select * from Messages Where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                return  new Message(resultSet.getString("content"),
                        resultSet.getInt("created_by"),
                        resultSet.getLong("created_at"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public Message insertMessage(Message message){

        try {
            Connection connection = GetConnection.getDataSource().getConnection();
            String sql = "Insert into Messages (content, created_by, created_at)values (?, ?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, message.getContent());
            preparedStatement.setInt(2, message.getCreated_by());
            preparedStatement.setLong(3, message.getCreated_at());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if(resultSet.next()){
                int generatedId = (int) resultSet.getLong(1);
                return new Message(generatedId, message.getContent(),message.getCreated_by(), message.getCreated_at());

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public void UpdateMessage(int id, Message message){

        try {
            Connection connection = GetConnection.getDataSource().getConnection();
            String sql = "Update Messages set (content, created_by, created_at) values (?,?,?) where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, message.getContent());
            preparedStatement.setInt(2, message.getCreated_by());
            preparedStatement.setLong(3, message.getCreated_at());
            preparedStatement.setInt(4, id);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
