package cat.uvic.teknos.db.bakery.models;

public interface Product {
    int getProductId();

    void setProductId(int productId);

    String getName();

    void setId(String name);

    float getPrice();

    void setPrice(float price);
}
