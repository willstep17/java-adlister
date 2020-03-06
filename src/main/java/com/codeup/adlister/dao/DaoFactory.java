package com.codeup.adlister.dao;

public class DaoFactory {
    private static Ads adsDao;
    private static MySQLUsersDao usersDao;
    private static Config config = new Config();

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }

    public static MySQLUsersDao getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }
}
