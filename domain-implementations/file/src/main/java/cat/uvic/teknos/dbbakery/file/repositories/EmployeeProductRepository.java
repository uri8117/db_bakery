package cat.uvic.teknos.dbbakery.file.repositories;

import cat.uvic.teknos.db.bakery.models.EmployeeProduct;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// Implementation of the EmployeeProductRepository interface
public class EmployeeProductRepository implements cat.uvic.teknos.db.bakery.repositories.EmployeeProductRepository {
    // Static map to store employee products
    private static Map<Integer, EmployeeProduct> employeeProducts = new HashMap<>();

    // Method to load employee products from file
    public static void load() {
        var currentDirectory = System.getProperty("user.dir") + "/src/main/resources/";

        try(var inputStream = new ObjectInputStream(new FileInputStream(currentDirectory + "employeeProducts.dat"))) {
            employeeProducts = (Map<Integer, EmployeeProduct>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to write employee products to file
    public static void write() {
        var currentDirectory = System.getProperty("user.dir") + "/src/main/resources/";

        try(var outputStream = new ObjectOutputStream(new FileOutputStream(currentDirectory + "employeeProducts.dat"))) {
            outputStream.writeObject(employeeProducts);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to save an employee product
    @Override
    public void save(EmployeeProduct model) {
        int key = model.getEmployeeId() * 1000 + model.getProductId();
        employeeProducts.put(key, model);
    }

    // Method to delete an employee product
    @Override
    public void delete(EmployeeProduct model) {
        int key = model.getEmployeeId() * 1000 + model.getProductId();
        employeeProducts.remove(key);
    }

    // Method to get an employee product by id
    @Override
    public EmployeeProduct get(Integer id) {
        throw new UnsupportedOperationException("Employee Product Repository does not support retrieving by id.");
    }

    // Method to get all employee products
    @Override
    public Set<EmployeeProduct> getAll() {
        return Set.copyOf(employeeProducts.values());
    }
}
