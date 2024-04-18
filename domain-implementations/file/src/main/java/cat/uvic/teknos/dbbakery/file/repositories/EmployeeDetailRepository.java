package cat.uvic.teknos.dbbakery.file.repositories;

import cat.uvic.teknos.db.bakery.models.EmployeeDetail;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// Implementation of the EmployeeDetailRepository interface
public class EmployeeDetailRepository implements cat.uvic.teknos.db.bakery.repositories.EmployeeDetailRepository {
    // Static map to store employee details
    private static Map<Integer, EmployeeDetail> employeeDetails = new HashMap<>();

    // Method to load employee details from file
    public static void load() {
        var currentDirectory = System.getProperty("user.dir") + "/src/main/resources/";

        try(var inputStream = new ObjectInputStream(new FileInputStream(currentDirectory + "employee_details.dat"))) {
            employeeDetails = (Map<Integer, EmployeeDetail>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to write employee details to file
    public static void write() {
        var currentDirectory = System.getProperty("user.dir") + "/src/main/resources/";

        try(var outputStream = new ObjectOutputStream(new FileOutputStream(currentDirectory + "employee_details.dat"))) {
            outputStream.writeObject(employeeDetails);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to save an employee detail
    @Override
    public void save(EmployeeDetail model) {
        employeeDetails.put(model.getEmployeeId(), model);
    }

    // Method to delete an employee detail
    @Override
    public void delete(EmployeeDetail model) {
        employeeDetails.remove(model.getEmployeeId());
    }

    // Method to get an employee detail by id
    @Override
    public EmployeeDetail get(Integer id) {
        return employeeDetails.get(id);
    }

    // Method to get all employee details
    @Override
    public Set<EmployeeDetail> getAll() {
        return Set.copyOf(employeeDetails.values());
    }
}
