package cat.uvic.teknos.db.bakery.models;

// Interface that defines the contract to represent an employee in the application
public interface Employee {

    // Method to get the employee's ID
    int getId();

    // Method to set the employee's ID
    void setId(int id);

    // Method to get the employee's name
    String getName();

    // Method to set the employee's name
    void setName(String name);

    // Method to get the employee's position
    String getPosition();

    // Method to set the employee's position
    void setPosition(String position);
}
