package cat.uvic.teknos.db.bakery.models;

// Interface that defines the contract to represent an employee product in the application
public interface EmployeeProduct {

    // Method to get the employee product's employee ID
    int getEmployeeId();

    // Method to set the employee product's employee ID
    void setEmployeeId(int employeeId);

    // Method to get the employee product's product ID
    int getProductId();

    // Method to set the employee product's product ID
    void setProductId(int productId);
}
