public class Item {
    private long id;
    private String name;
    private int priceInCents;
    private String priceString;

    public Item(long id, String name, int priceInCents) {
        this.id = id;
        this.name = name;
        this.priceInCents = priceInCents;
        this.priceString = this.centsToDollars(priceInCents);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriceInCents() {
        return priceInCents;
    }

    public void setPriceInCents(int priceInCents) {
        this.priceInCents = priceInCents;
    }

    public String getPriceString() {
        return priceString;
    }

    public void setPriceString(String priceString) {
        this.priceString = priceString;
    }

    protected String centsToDollars(int costInCents) {
        String returnDollars = Integer.toString(costInCents);
        if(returnDollars.length() > 2) {
            returnDollars = new StringBuilder(returnDollars).insert(returnDollars.length() -2,".").insert(0, "$").toString();
        }
        return returnDollars;
    }

}