package cat.uvic.teknos.db.bakery.models;

// Interface that defines the contract to represent an employee order in the application
public interface EmployeeOrder {

    // Method to get the employee order's employee ID
    int getEmployeeId();

    // Method to set the employee order's employee ID
    void setEmployeeId(int employeeId);

    // Method to get the employee order's order ID
    int getOrderId();

    // Method to set the employee order's order ID
    void setOrderId(int orderId);
}
