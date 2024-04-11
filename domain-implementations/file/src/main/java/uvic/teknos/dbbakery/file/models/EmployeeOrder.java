package uvic.teknos.dbbakery.file.models;

public class EmployeeOrder implements cat.uvic.teknos.db.bakery.models.EmployeeOrder {
    // Attributes of the class
    private int employeeId;
    private int orderId;

    // Methods to get and set the employee order's employee ID
    @Override
    public int getEmployeeId() {
        return employeeId;
    }

    @Override
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    // Methods to get and set the employee order's order ID
    @Override
    public int getOrderId() {
        return orderId;
    }

    @Override
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
