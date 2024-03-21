package cat.uvic.teknos.db.bakery.models;

import java.sql.Date;

public interface Order {
    int getOrderId();

    void setOrderId(int orderId);

    Date getOrderDate();

    void setOrderDate(Date date);

    int getClientId();

    void setClientId(int clientId);
}
