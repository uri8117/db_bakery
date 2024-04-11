package uvic.teknos.dbbakery.file.models;

public class OrderItem implements cat.uvic.teknos.db.bakery.models.OrderItem {
    // Attributes of the class
    private int id;
    private int orderId;
    private int productId;
    private int quantity;

    // Methods to get and set the order item's ID
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    // Methods to get and set the ID of the order to which the item belongs
    @Override
    public int getOrderId() {
        return orderId;
    }

    @Override
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    // Methods to get and set the ID of the product in the order item
    @Override
    public int getProductId() {
        return productId;
    }

    @Override
    public void setProductId(int productId) {
        this.productId = productId;
    }

    // Methods to get and set the quantity of the product in the order item
    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
