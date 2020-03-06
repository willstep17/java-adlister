package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//Email regex: .+@.+\.[a-z]{3,4}
//Password regex: ^(?=.*?[a-z])(?=.*?[A-Z])(?=.*?\d)[a-zA-Z\d]{6,}$

public class MySQLUsersDao implements Users {
    private Connection connection = null;

    public static void main(String[] args) {
        Config config = new Config();
        MySQLUsersDao testDao = new MySQLUsersDao(config);

        User testUser = testDao.findByUsername("chris");
        System.out.println(testUser.getEmail());

//        User secondTestUser = new User(45, "fake", "akailjkyfaeaf@faefagiafael.com", "1111111f");
//        testDao.insert(secondTestUser);

    }

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            this.connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException sqe) {
            System.out.println("Error connecting to database:\n" + sqe);
        }
    }

//    String sql = "SELECT * FROM products WHERE name LIKE ?";
//    String searchTermWithWildcards = "%" + searchTerm + "%";
//
//    PreparedStatement stmt = connection.prepareStatement(sql);
//    stmt.setString(1, searchTermWithWildcards);
//
//    ResultSet rs = stmt.executeQuery();
//    while(rs.next()) {
//        // do something with the search results
//    }

    @Override
    public User findByUsername(String inputUsername) {
        try {
//            String sql = "SELECT * FROM users WHERE username LIKE ?";
            String sql = "SELECT * FROM users WHERE username = ?";
//            String searchTermWithWildcards = "%" + inputUsername + "%";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, inputUsername);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return extractUser(rs);
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Error finding user.", e);
        }
    }

//    String sql = "INSERT INTO products(name, category, price) VALUES (?, ?, ?)";
//    PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

//    // For the sake of easier demonstration we are using literals here
//    stmt.setString(1, "hammer");
//    stmt.setString(2, "tools");
//    stmt.setFloat(3, 19.99);
//
//    stmt.executeUpdate();
//    ResultSet generatedIdResultSet = stmt.getGeneratedKeys();

    @Override
    public Long insert(User user) {
        long returnIndex = -1;
        try {
            String sql = "INSERT INTO users(email, password, username) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getUsername());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs != null && rs.next()) {
                returnIndex = rs.getLong(1);
            }
            return returnIndex;
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new user.", e);
        }
    }

    private User extractUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
        );
    }

}
