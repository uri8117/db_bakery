package cat.uvic.teknos.db.bakery.models;

public interface Order_item {
    int getOrderItemId();

    void setOrderItemId(int orderItemId);

    int getOrderId();

    void setOrderId(int orderId);

    int getProductId();

    void setProductId(int productId);

    int getQuantity();

    void setQuantity(int quantity);
}
