package cat.uvic.teknos.db.bakery.models;

import java.util.Date;

// Interface that defines the contract to represent an order in the application
public interface Order {

    // Method to get the order's ID
    int getId();

    // Method to set the order's ID
    void setId(int id);

    // Method to get the order's date
    Date getOrderDate();

    // Method to set the order's date
    void setOrderDate(Date orderDate);

    // Method to get the ID of the client placing the order
    int getClientId();

    // Method to set the ID of the client placing the order
    void setClientId(int clientId);
}
