package cat.uvic.teknos.db.bakery.models;

// Interface that defines the contract to represent employee details in the application
public interface EmployeeDetail {

    // Method to get the employee's ID
    int getEmployeeId();

    // Method to set the employee's ID
    void setEmployeeId(int employeeId);

    // Method to get the employee's birthdate
    String getBirthdate();

    // Method to set the employee's birthdate
    void setBirthdate(String birthdate);

    // Method to get the employee's salary
    double getSalary();

    // Method to set the employee's salary
    void setSalary(double salary);
}
