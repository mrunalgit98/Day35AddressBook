package org;

import java.sql.*;
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
        String s1=" select * from addressbook";
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO addressbook(FirstName, LastName, Address, City, State, ZipCode, PhoneNumber, Email, type) values (?, ?, ?, ?, ?, ?, ?, ?, ?);");
            preparedStatement.setString(1,"virat");
                 preparedStatement.setString(2,  "virat");
                    preparedStatement.setString(3,"gurgaon");
                    preparedStatement.setString(4,"noida");
                   preparedStatement.setString(5, "delhi");
                    preparedStatement.setString(6,"4544");
                   preparedStatement.setString(7,"0945234423");
                   preparedStatement.setString(8,"virat@232");
                    preparedStatement.setString(9,"friend");
            java.sql.Statement statement = connection.createStatement();
            int result=preparedStatement.executeUpdate();
            ResultSet resultSet = statement.executeQuery(s1);
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("FirstName");
                String lname = resultSet.getString("LastName");
                String city = resultSet.getString("City");
                String state =resultSet.getString("State");
                String phone=resultSet.getString("PhoneNumber");
                String add=resultSet.getString("Address");
               // LocalDate start = resultSet.getDate("start").toLocalDate();
                System.out.println(id+" "+name+" "+ lname + " "+ " " + city + " " + state + " " +phone+ " " +add);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}