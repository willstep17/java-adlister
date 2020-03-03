import java.util.ArrayList;
import java.util.List;

public class ListItemsDao implements Items {
    private List<Item> items;

    public List<Item> all() {
        if (items == null) {
            items = generateItems();
        }
        return items;
    }

    private List<Item> generateItems() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1,"Bananas", 400));
        items.add(new Item(2,"Apple", 150));
        items.add(new Item(3,"Grapes", 300));
        items.add(new Item(4,"Orange", 190));
        items.add(new Item(5,"Avocado", 250));
        items.add(new Item(6,"Blueberries", 600));
        items.add(new Item(7,"Raspberries", 550));
        items.add(new Item(8,"Kiwi", 160));
        items.add(new Item(9,"Tangerine", 220));
        items.add(new Item(10,"Potato", 90));
        return items;
    }
}
