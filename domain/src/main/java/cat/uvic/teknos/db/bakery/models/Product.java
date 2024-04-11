package cat.uvic.teknos.db.bakery.models;

// Interface that defines the contract to represent a product in the application
public interface Product {

    // Method to get the product's ID
    int getId();

    // Method to set the product's ID
    void setId(int id);

    // Method to get the product's name
    String getName();

    // Method to set the product's name
    void setName(String name);

    // Method to get the price of the product
    double getPrice();

    // Method to set the price of the product
    void setPrice(double price);
}
