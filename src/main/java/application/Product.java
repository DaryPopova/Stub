package application;

public class Product implements JsonObject {

    private Integer id;
    private String name;
    private Double price;

    public Product(Integer id, String name, Double price) throws Exception {
        this.id = id;
        this.name = name;
        if (price > 0) {
            this.price = price;
        } else throw new Exception("price must > 0");
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}
