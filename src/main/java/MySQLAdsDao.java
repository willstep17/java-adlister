import java.sql.*;
import com.mysql.cj.jdbc.Driver;

import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads{
    private Connection connection;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            this.connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException sqe) {
            System.out.println(sqe);
        }
    }

    public static void main(String[] args) {
        Config config = new Config();
        MySQLAdsDao testDao = new MySQLAdsDao(config);
//        List<Ad> testArray = testDao.all();
//        for (Ad ad : testArray) {
//            System.out.println(ad.getId());
//        }

        Ad testAd = new Ad(60, 3, "Django Unchained", "McDonalds");
        long test = testDao.insert(testAd);

    }

    public List<Ad> all() {
        List<Ad> ads = new ArrayList<>();
        try {
            String selectQuery = "SELECT * FROM ads";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(selectQuery);
            while(rs.next()) {
                ads.add(new Ad(rs.getLong("id"),
                            rs.getLong("user_id"),
                            rs.getString("title"),
                            rs.getString("content")));
            }
        } catch (SQLException sqe) {
            System.out.println(sqe);
        }
        return ads;
    }

    public Long insert(Ad ad) {
        long newId = 0;
        String insertStatement = "INSERT INTO ads(user_id, title, content) VALUES (" + ad.getUserId() + ", '" + ad.getTitle() + "', '" + ad.getDescription() + "')";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(insertStatement, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                System.out.println("Inserted a new ad! New ID: " + rs.getLong(1));
            }
            newId =  rs.getLong(1);
        } catch (SQLException sqe) {
            System.out.println(sqe);
        }
        return newId;
    }
}
