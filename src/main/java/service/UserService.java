package service;

import DBConnection.DBConnection;
import model.User;

import javax.jws.soap.SOAPBinding;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    public void insertUser(User user) {
        String query = "insert into user (userName, password, fullName)" + "values(?,?,?)";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);
        try {
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFullName());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        String query = "delete from user where id =? ";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);
        try {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateUser(User user, int id) throws SQLException {
        String query = "UPDATE user SET userName =? , password =? , fullName =? " + "WHERE id =?";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);


        preparedStatement.setString(1, user.getUserName());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getFullName());
        preparedStatement.setInt(4, id);
        preparedStatement.execute();

    }

    // Login
    public User getUser(String userName, String password) {

        User user = null;

        String query = "Select * from user where userName =? and password =? ";

        PreparedStatement preparedStatement = new DBConnection().getStatement(query);
        try {
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setFullName(rs.getString("fullName"));


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;


    }

    //GETTING USER LIST
    public List<User> getUserList() throws SQLException {

        List<User> arraylist = new ArrayList<>();
        String query = "Select * from user";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUserName(rs.getString("userName"));
            user.setPassword(rs.getString("password"));
            user.setFullName(rs.getString("fullName"));

            arraylist.add(user);

        }
        return arraylist;
    }

    public User getUserRow(int id) {
        User user = new User();
        String query = "select * from user where id =?";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);


        try {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("userName"));
                user.setFullName(resultSet.getString("fullName"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

    }
}









