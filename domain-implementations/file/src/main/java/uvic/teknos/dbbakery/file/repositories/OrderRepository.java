package uvic.teknos.dbbakery.file.repositories;

import cat.uvic.teknos.db.bakery.models.Order;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// Implementation of the OrderRepository interface
public class OrderRepository implements cat.uvic.teknos.db.bakery.repositories.OrderRepository {
    // Static map to store orders
    private static Map<Integer, Order> orders = new HashMap<>();

    // Method to load orders from file
    public static void load() {
        var currentDirectory = System.getProperty("user.dir") + "/src/main/resources/";

        try(var inputStream = new ObjectInputStream(new FileInputStream(currentDirectory + "orders.dat"))) {
            orders = (Map<Integer, Order>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to write orders to file
    public static void write() {
        var currentDirectory = System.getProperty("user.dir") + "/src/main/resources/";

        try(var outputStream = new ObjectOutputStream(new FileOutputStream(currentDirectory + "orders.dat"))) {
            outputStream.writeObject(orders);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to save an order
    @Override
    public void save(Order model) {
        if (model.getId() <= 0) {
            // generate new id
            var newId = orders.keySet().stream().mapToInt(k -> k).max().orElse(0) + 1;
            orders.put(newId, model);
        } else {
            orders.put(model.getId(), model);
        }
    }

    // Method to delete an order
    @Override
    public void delete(Order model) {
        orders.remove(model.getId());
    }

    // Method to get an order by id
    @Override
    public Order get(Integer id) {
        return orders.get(id);
    }

    // Method to get all orders
    @Override
    public Set<Order> getAll() {
        return Set.copyOf(orders.values());
    }
}
