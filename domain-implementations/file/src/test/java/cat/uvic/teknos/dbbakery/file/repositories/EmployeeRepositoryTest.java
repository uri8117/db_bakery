package cat.uvic.teknos.dbbakery.file.repositories;

import org.junit.jupiter.api.Test;
import cat.uvic.teknos.dbbakery.file.models.Employee;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeRepositoryTest {

    @Test
    void save() {

        // Define the path to the data file
        var path = System.getProperty("user.dir") + "/src/test/resources/employees.ser/";

        // Create an instance of the repository
        var employeeRepository = new EmployeeRepository(path);

        // Create a test employee
        var employee = new Employee();
        employee.setId(1);
        employee.setName("Ben Ten");
        employee.setPosition("Worked");

        // Save the employee
        employeeRepository.save(employee);

        // Assert that the employee ID is greater than 0 after saving
        assertTrue(employee.getId() > 0);

        // Assert that the saved employee can be retrieved
        assertNotNull(employeeRepository.get(employee.getId()));

        // Load data from file
        employeeRepository.load();

        // Assert that the employee can still be retrieved after loading data
        assertNotNull(employeeRepository.get(employee.getId()));
    }

    @Test
    void update() {
        // Define the path to the data file
        var path = System.getProperty("user.dir") + "/src/test/resources/employees.ser";

        // Create an instance of the repository
        var repository = new EmployeeRepository(path);

        // Create a test employee
        var employee = new Employee();
        employee.setId(1);
        employee.setName("Ben Twelve");
        employee.setPosition("Manager");

        // Save the employee
        repository.save(employee);

        // Retrieve the employee from the repository
        var updatedEmployee = repository.get(1);

        // Update the employee's name
        updatedEmployee.setName("Updated Name");

        // Save the updated employee
        repository.save(updatedEmployee);

        // Retrieve the employee again
        var retrievedEmployee = repository.get(1);

        // Assert that the employee's name has been updated
        assertEquals("Updated Name", retrievedEmployee.getName());
    }

    @Test
    void delete() {
        // Define the path to the data file
        var path = System.getProperty("user.dir") + "/src/test/resources/employees.ser/";

        // Create an instance of the repository
        var repository = new EmployeeRepository(path);

        // Create a test employee
        var employee = new Employee();

        // Delete the employee
        repository.delete(employee);

        // Assert that the employee has been deleted
        assertNull(repository.get(employee.getId()));
    }

}
