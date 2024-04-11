package uvic.teknos.dbbakery.file.models;

public class Product implements cat.uvic.teknos.db.bakery.models.Product {
    // Attributes of the class
    private int id;
    private String name;
    private double price;

    // Methods to get and set the product's ID
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    // Methods to get and set the product's name
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    // Methods to get and set the price of the product
    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }
}
