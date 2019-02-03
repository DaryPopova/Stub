package application;

public class Product implements JsonObject {
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) throws Exception {
        this.price = price;
    }

    private Integer id;
    private String name;
    private Double price;

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