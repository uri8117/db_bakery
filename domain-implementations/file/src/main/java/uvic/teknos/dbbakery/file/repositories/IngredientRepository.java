package uvic.teknos.dbbakery.file.repositories;

import cat.uvic.teknos.db.bakery.models.Ingredient;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// Implementation of the IngredientRepository interface
public class IngredientRepository implements cat.uvic.teknos.db.bakery.repositories.IngredientRepository {
    // Static map to store ingredients
    private static Map<Integer, Ingredient> ingredients = new HashMap<>();

    // Method to load ingredients from file
    public static void load() {
        var currentDirectory = System.getProperty("user.dir") + "/src/main/resources/";

        try(var inputStream = new ObjectInputStream(new FileInputStream(currentDirectory + "ingredients.dat"))) {
            ingredients = (Map<Integer, Ingredient>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to write ingredients to file
    public static void write() {
        var currentDirectory = System.getProperty("user.dir") + "/src/main/resources/";

        try(var outputStream = new ObjectOutputStream(new FileOutputStream(currentDirectory + "ingredients.dat"))) {
            outputStream.writeObject(ingredients);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to save an ingredient
    @Override
    public void save(Ingredient model) {
        if (model.getId() <= 0) {
            // generate new id
            var newId = ingredients.keySet().stream().mapToInt(k -> k).max().orElse(0) + 1;
            ingredients.put(newId, model);
        } else {
            ingredients.put(model.getId(), model);
        }
    }

    // Method to delete an ingredient
    @Override
    public void delete(Ingredient model) {
        ingredients.remove(model.getId());
    }

    // Method to get an ingredient by id
    @Override
    public Ingredient get(Integer id) {
        return ingredients.get(id);
    }

    // Method to get all ingredients
    @Override
    public Set<Ingredient> getAll() {
        return Set.copyOf(ingredients.values());
    }
}
