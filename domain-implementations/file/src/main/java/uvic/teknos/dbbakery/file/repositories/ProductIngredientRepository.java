package uvic.teknos.dbbakery.file.repositories;

import cat.uvic.teknos.db.bakery.models.ProductIngredient;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// Implementation of the ProductIngredientRepository interface
public class ProductIngredientRepository implements cat.uvic.teknos.db.bakery.repositories.ProductIngredientRepository {
    // Static map to store product ingredients
    private static Map<Integer, ProductIngredient> productIngredients = new HashMap<>();

    // Method to load product ingredients from file
    public static void load() {
        var currentDirectory = System.getProperty("user.dir") + "/src/main/resources/";

        try(var inputStream = new ObjectInputStream(new FileInputStream(currentDirectory + "productIngredients.dat"))) {
            productIngredients = (Map<Integer, ProductIngredient>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to write product ingredients to file
    public static void write() {
        var currentDirectory = System.getProperty("user.dir") + "/src/main/resources/";

        try(var outputStream = new ObjectOutputStream(new FileOutputStream(currentDirectory + "productIngredients.dat"))) {
            outputStream.writeObject(productIngredients);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to save a product ingredient
    @Override
    public void save(ProductIngredient model) {
        int key = model.getProductId() * 1000 + model.getIngredientId();
        productIngredients.put(key, model);
    }

    // Method to delete a product ingredient
    @Override
    public void delete(ProductIngredient model) {
        int key = model.getProductId() * 1000 + model.getIngredientId();
        productIngredients.remove(key);
    }

    // Method to get a product ingredient by id
    @Override
    public ProductIngredient get(Integer id) {
        throw new UnsupportedOperationException("Product Ingredient Repository does not support retrieving by id.");
    }

    // Method to get all product ingredients
    @Override
    public Set<ProductIngredient> getAll() {
        return Set.copyOf(productIngredients.values());
    }
}
