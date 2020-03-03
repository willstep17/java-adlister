public class DaoFactory {
    private static Ads adsDao;
    private static Items itemsDao;

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new ListAdsDao();
        }
        return adsDao;
    }

    public static Items getItemsDao() {
        if (itemsDao == null) {
            itemsDao = new ListItemsDao();
        }
        return itemsDao;
    }
}
