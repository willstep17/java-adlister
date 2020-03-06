package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public static void main(String[] args) {
        Ad testAd = new Ad(45,1, "test", "test");
        Config config = new Config();
        MySQLAdsDao testDao = new MySQLAdsDao(config);
        testDao.insert(testAd);
    }

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        try {
            String sql = "SELECT * FROM ads";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        long returnIndex = -1;
        try {
            String sql = "INSERT INTO ads(user_id, title, description) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int userId = (int) ad.getUserId();
            stmt.setInt(1, userId);
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs != null && rs.next()) {
                returnIndex = rs.getLong(1);
            }
            return returnIndex;
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }
}
