package uvic.teknos.dbbakery.file.repositories;

import cat.uvic.teknos.db.bakery.models.Employee;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Implementation of the EmployeeRepository interface
public class EmployeeRepository implements cat.uvic.teknos.db.bakery.repositories.EmployeeRepository {
    // Static map to store employees
    private static Map<Integer, Employee> employees = new HashMap<>();

    // Method to load employees from file
    public static void load() {
        var currentDirectory = System.getProperty("user.dir") + "/src/main/resources/";

        try(var inputStream = new ObjectInputStream(new FileInputStream(currentDirectory + "employees.dat"))) {
            employees = (Map<Integer, Employee>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to write employees to file
    public void write() {
        var currentDirectory = System.getProperty("user.dir") + "/src/main/resources/";

        try(var outputStream = new ObjectOutputStream(new FileOutputStream(currentDirectory + "employees.dat"))) {
            outputStream.writeObject(employees);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to save an employee
    @Override
    public void save(Employee model) {
        if (model.getId() <= 0) {
            // generate new id
            var newId = employees.keySet().stream().mapToInt(k -> k).max().orElse(0) + 1;
            employees.put(newId, model);
        } else {
            employees.put(model.getId(), model);
        }
        write();
    }

    public void update(){
        var currentDirectory = System.getProperty("user.dir") + "/src/main/resources/";

        try (var outputStream = new ObjectOutputStream(new FileOutputStream(currentDirectory + "employees.dat"))) {
            outputStream.writeObject(employees);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to delete an employee
    @Override
    public void delete(Employee model) {
        var currentDirectory = System.getProperty("user.dir") + "/src/main/resources/";

        try (var outputStream = new ObjectOutputStream(new FileOutputStream(currentDirectory + "employees.dat"))) {

            for (Iterator<Map.Entry<Integer, Employee>> iterator = employees.entrySet().iterator(); iterator.hasNext(); ) {
                Map.Entry<Integer, Employee> entry = iterator.next();
                if (entry.getValue().equals(model)) {
                    iterator.remove();
                    break;
                }
            }
            outputStream.writeObject(employees);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to get an employee by id
    @Override
    public Employee get(Integer id) {
        return employees.get(id);
    }

    // Method to get all employees
    @Override
    public Set<Employee> getAll() {
        return Set.copyOf(employees.values());
    }

    // Method to get an employee by name
    @Override
    public Employee getByName(String name) {
        for (Employee employee : employees.values()) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }
}
