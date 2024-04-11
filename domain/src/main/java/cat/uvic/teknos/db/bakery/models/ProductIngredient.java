package cat.uvic.teknos.db.bakery.models;

// Interface that defines the contract to represent a product ingredient in the application
public interface ProductIngredient {

    // Method to get the product ingredient's product ID
    int getProductId();

    // Method to set the product ingredient's product ID
    void setProductId(int productId);

    // Method to get the product ingredient's ingredient ID
    int getIngredientId();

    // Method to set the product ingredient's ingredient ID
    void setIngredientId(int ingredientId);
}
