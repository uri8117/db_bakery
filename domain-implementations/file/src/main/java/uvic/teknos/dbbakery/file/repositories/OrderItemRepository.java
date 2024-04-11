package uvic.teknos.dbbakery.file.repositories;

import cat.uvic.teknos.db.bakery.models.OrderItem;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// Implementation of the OrderItemRepository interface
public class OrderItemRepository implements cat.uvic.teknos.db.bakery.repositories.OrderItemRepository {
    // Static map to store order items
    private static Map<Integer, OrderItem> orderItems = new HashMap<>();

    // Method to load order items from file
    public static void load() {
        var currentDirectory = System.getProperty("user.dir") + "/src/main/resources/";

        try(var inputStream = new ObjectInputStream(new FileInputStream(currentDirectory + "orderItems.dat"))) {
            orderItems = (Map<Integer, OrderItem>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to write order items to file
    public static void write() {
        var currentDirectory = System.getProperty("user.dir") + "/src/main/resources/";

        try(var outputStream = new ObjectOutputStream(new FileOutputStream(currentDirectory + "orderItems.dat"))) {
            outputStream.writeObject(orderItems);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to save an order item
    @Override
    public void save(OrderItem model) {
        if (model.getId() <= 0) {
            // generate new id
            var newId = orderItems.keySet().stream().mapToInt(k -> k).max().orElse(0) + 1;
            orderItems.put(newId, model);
        } else {
            orderItems.put(model.getId(), model);
        }
    }

    // Method to delete an order item
    @Override
    public void delete(OrderItem model) {
        orderItems.remove(model.getId());
    }

    // Method to get an order item by id
    @Override
    public OrderItem get(Integer id) {
        return orderItems.get(id);
    }

    // Method to get all order items
    @Override
    public Set<OrderItem> getAll() {
        return Set.copyOf(orderItems.values());
    }
}
