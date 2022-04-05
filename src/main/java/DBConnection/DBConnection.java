package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {
        Connection connection = null;

        public  DBConnection(){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                String DB_URL = "jdbc:mysql://localhost:3306/studentmanagement";
                String name = "root";
                String password = "";

                this.connection = DriverManager.getConnection(DB_URL, name , password);
                System.out.println("Database Connected !!");

            } catch (ClassNotFoundException | SQLException e){
                e.printStackTrace();
            }

        }

        public static void main(String[] args) {
            DBConnection dbConnection = new DBConnection();;

        }
        public PreparedStatement getStatement(String query){
            PreparedStatement pstm = null;
            try{
                pstm = connection.prepareStatement(query);


            } catch (SQLException e){
                e.printStackTrace();
            }
            return pstm;

        }
    }


