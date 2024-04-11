package cat.uvic.teknos.db.bakery.models;

// Interface that defines the contract to represent an order item in the application
public interface OrderItem {

    // Method to get the order item's ID
    int getId();

    // Method to set the order item's ID
    void setId(int id);

    // Method to get the ID of the order to which the item belongs
    int getOrderId();

    // Method to set the ID of the order to which the item belongs
    void setOrderId(int orderId);

    // Method to get the ID of the product in the order item
    int getProductId();

    // Method to set the ID of the product in the order item
    void setProductId(int productId);

    // Method to get the quantity of the product in the order item
    int getQuantity();

    // Method to set the quantity of the product in the order item
    void setQuantity(int quantity);
}
