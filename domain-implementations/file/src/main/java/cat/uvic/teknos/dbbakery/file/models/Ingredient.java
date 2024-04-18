package cat.uvic.teknos.dbbakery.file.models;

public class Ingredient implements cat.uvic.teknos.db.bakery.models.Ingredient {
    // Attributes of the class
    private int id;
    private String name;
    private int supplierId;
    private double price;

    // Methods to get and set the ingredient's ID
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    // Methods to get and set the ingredient's name
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    // Methods to get and set the ID of the supplier supplying this ingredient
    @Override
    public int getSupplierId() {
        return supplierId;
    }

    @Override
    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    // Methods to get and set the price of the ingredient
    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }
}
