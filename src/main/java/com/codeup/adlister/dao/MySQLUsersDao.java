package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;
import java.sql.*;

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

    @Override
    public User findByUsername(String inputUsername) {
        String sql = "SELECT * FROM users WHERE username = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, inputUsername);
            ResultSet rs = stmt.executeQuery();
            return extractUser(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding user.", e);
        }
    }

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
        if (! rs.next()) {
            return null;
        }
        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
        );
    }

}
