package cat.uvic.teknos.dbbakery.file.models;

import java.util.Date;

public class Order implements cat.uvic.teknos.db.bakery.models.Order {
    // Attributes of the class
    private int id;
    private Date orderDate;
    private int clientId;

    // Methods to get and set the order's ID
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    // Methods to get and set the order's date
    @Override
    public Date getOrderDate() {
        return orderDate;
    }

    @Override
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    // Methods to get and set the ID of the client placing the order
    @Override
    public int getClientId() {
        return clientId;
    }

    @Override
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}
