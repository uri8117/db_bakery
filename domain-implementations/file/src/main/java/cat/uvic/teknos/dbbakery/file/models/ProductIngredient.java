package cat.uvic.teknos.dbbakery.file.models;

public class ProductIngredient implements cat.uvic.teknos.db.bakery.models.ProductIngredient {
    // Attributes of the class
    private int productId;
    private int ingredientId;

    // Methods to get and set the product ingredient's product ID
    @Override
    public int getProductId() {
        return productId;
    }

    @Override
    public void setProductId(int productId) {
        this.productId = productId;
    }

    // Methods to get and set the product ingredient's ingredient ID
    @Override
    public int getIngredientId() {
        return ingredientId;
    }

    @Override
    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }
}
