package cat.uvic.teknos.dbbakery.file.models;

public class EmployeeProduct implements cat.uvic.teknos.db.bakery.models.EmployeeProduct {
    // Attributes of the class
    private int employeeId;
    private int productId;

    // Methods to get and set the employee product's employee ID
    @Override
    public int getEmployeeId() {
        return employeeId;
    }

    @Override
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    // Methods to get and set the employee product's product ID
    @Override
    public int getProductId() {
        return productId;
    }

    @Override
    public void setProductId(int productId) {
        this.productId = productId;
    }
}
