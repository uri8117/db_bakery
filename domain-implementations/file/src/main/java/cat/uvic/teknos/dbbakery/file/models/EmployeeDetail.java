package cat.uvic.teknos.dbbakery.file.models;

public class EmployeeDetail implements cat.uvic.teknos.db.bakery.models.EmployeeDetail {
    // Attributes of the class
    private int employeeId;
    private String birthdate;
    private double salary;

    // Methods to get and set the employee's ID
    @Override
    public int getEmployeeId() {
        return employeeId;
    }

    @Override
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    // Methods to get and set the employee's birthdate
    @Override
    public String getBirthdate() {
        return birthdate;
    }

    @Override
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    // Methods to get and set the employee's salary
    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
