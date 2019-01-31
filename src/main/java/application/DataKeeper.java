package application;

import java.util.HashMap;

public class DataKeeper {
    HashMap<Integer, Product> keeper = new HashMap<>();

    public Product getProduct(Integer id) {
        return keeper.get(id);
    }

    public void addProduct(Integer id, String name, double price) throws Exception {
        keeper.put(id, new Product(id, name, price));
    }
}
