package cat.uvic.teknos.db.bakery.models;

// Interface that defines the contract to represent an ingredient in the application
public interface Ingredient {

    // Method to get the ingredient's ID
    int getId();

    // Method to set the ingredient's ID
    void setId(int id);

    // Method to get the ingredient's name
    String getName();

    // Method to set the ingredient's name
    void setName(String name);

    // Method to get the ID of the supplier supplying this ingredient
    int getSupplierId();

    // Method to set the ID of the supplier supplying this ingredient
    void setSupplierId(int supplierId);

    // Method to get the price of the ingredient
    double getPrice();

    // Method to set the price of the ingredient
    void setPrice(double price);
}
