package application;

import java.util.HashMap;

public class DataKeeper {
    HashMap<Integer, Product> keeper = new HashMap<>();

    public Product getProduct(Integer id) {
        return keeper.get(id);
    }

    public void addProduct(Product product) throws Exception {
        keeper.put(product.getId(), product);
    }
}
