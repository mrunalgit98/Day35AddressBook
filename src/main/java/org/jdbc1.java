package org;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//import com.mysql.cj.xdevapi.Statement;

public class jdbc1 {

    public static Connection getConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/addressbookservice?useSSL=false";
        String userName = "root";
        String passWord = "123456789";
        Connection con;
        con = DriverManager.getConnection(jdbcURL, userName, passWord);
        return con;
    }

    public static void main(String [] args) {
        String s1="UPDATE addressbook SET PhoneNumber=78787878 where FirstName='mrunal'";
        String sql = "SELECT * FROM addressbook";
        try {
            Connection connection = getConnection();
            java.sql.Statement statement = connection.createStatement();
            int result =statement.executeUpdate(s1);
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("Firstname");
                String lname = resultSet.getString("LastName");
                String city = resultSet.getString("City");
                String state =resultSet.getString("State");
                String phone=resultSet.getString("PhoneNumber");
               // LocalDate start = resultSet.getDate("start").toLocalDate();
                System.out.println(id+" "+name+" "+ lname + " "+ " " + city + " " + state + " " +phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}