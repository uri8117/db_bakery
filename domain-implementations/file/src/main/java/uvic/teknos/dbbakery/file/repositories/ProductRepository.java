package uvic.teknos.dbbakery.file.repositories;

import cat.uvic.teknos.db.bakery.models.Product;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// Implementation of the ProductRepository interface
public class ProductRepository implements cat.uvic.teknos.db.bakery.repositories.ProductRepository {
    // Static map to store products
    private static Map<Integer, Product> products = new HashMap<>();

    // Method to load products from file
    public static void load() {
        var currentDirectory = System.getProperty("user.dir") + "/src/main/resources/";

        try(var inputStream = new ObjectInputStream(new FileInputStream(currentDirectory + "products.dat"))) {
            products = (Map<Integer, Product>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to write products to file
    public static void write() {
        var currentDirectory = System.getProperty("user.dir") + "/src/main/resources/";

        try(var outputStream = new ObjectOutputStream(new FileOutputStream(currentDirectory + "products.dat"))) {
            outputStream.writeObject(products);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to save a product
    @Override
    public void save(Product model) {
        if (model.getId() <= 0) {
            // generate new id
            var newId = products.keySet().stream().mapToInt(k -> k).max().orElse(0) + 1;
            products.put(newId, model);
        } else {
            products.put(model.getId(), model);
        }
    }

    // Method to delete a product
    @Override
    public void delete(Product model) {
        products.remove(model.getId());
    }

    // Method to get a product by id
    @Override
    public Product get(Integer id) {
        return products.get(id);
    }

    // Method to get all products
    @Override
    public Set<Product> getAll() {
        return Set.copyOf(products.values());
    }
}
