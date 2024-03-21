package cat.uvic.teknos.db.bakery.models;

public interface Ingredient {
    int getIngredientId();

    void setIngredientId(int ingredientId);

    int getSupplierId();

    void setSupplierId(int supplierId);

    float getPrice();

    void setPrice(float price);
}
