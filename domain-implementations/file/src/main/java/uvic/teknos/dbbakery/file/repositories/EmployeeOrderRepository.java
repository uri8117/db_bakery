package uvic.teknos.dbbakery.file.repositories;

import cat.uvic.teknos.db.bakery.models.EmployeeOrder;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// Implementation of the EmployeeOrderRepository interface
public class EmployeeOrderRepository implements cat.uvic.teknos.db.bakery.repositories.EmployeeOrderRepository {
    // Static map to store employee orders
    private static Map<Integer, EmployeeOrder> employeeOrders = new HashMap<>();

    // Method to load employee orders from file
    public static void load() {
        var currentDirectory = System.getProperty("user.dir") + "/src/main/resources/";

        try(var inputStream = new ObjectInputStream(new FileInputStream(currentDirectory + "employeeOrders.dat"))) {
            employeeOrders = (Map<Integer, EmployeeOrder>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to write employee orders to file
    public static void write() {
        var currentDirectory = System.getProperty("user.dir") + "/src/main/resources/";

        try(var outputStream = new ObjectOutputStream(new FileOutputStream(currentDirectory + "employeeOrders.dat"))) {
            outputStream.writeObject(employeeOrders);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to save an employee order
    @Override
    public void save(EmployeeOrder model) {
        int key = model.getEmployeeId() * 1000 + model.getOrderId();
        employeeOrders.put(key, model);
    }

    // Method to delete an employee order
    @Override
    public void delete(EmployeeOrder model) {
        int key = model.getEmployeeId() * 1000 + model.getOrderId();
        employeeOrders.remove(key);
    }

    // Method to get an employee order by id
    @Override
    public EmployeeOrder get(Integer id) {
        throw new UnsupportedOperationException("Employee Order Repository does not support retrieving by id.");
    }

    // Method to get all employee orders
    @Override
    public Set<EmployeeOrder> getAll() {
        return Set.copyOf(employeeOrders.values());
    }
}
