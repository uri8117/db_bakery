package uvic.teknos.dbbakery.file.repositories;

import cat.uvic.teknos.db.bakery.models.Client;
import cat.uvic.teknos.db.bakery.models.Supplier;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Implementation of the SupplierRepository interface
public class SupplierRepository implements cat.uvic.teknos.db.bakery.repositories.SupplierRepository {
    // Static map to store suppliers
    private static Map<Integer, Supplier> suppliers = new HashMap<>();

    // Method to load suppliers from file
    public static void load() {
        var currentDirectory = System.getProperty("user.dir") + "/src/main/resources/";

        try(var inputStream = new ObjectInputStream(new FileInputStream(currentDirectory + "suppliers.dat"))) {
            suppliers = (Map<Integer, Supplier>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to write suppliers to file
    public void write() {
        var currentDirectory = System.getProperty("user.dir") + "/src/main/resources/";

        try(var outputStream = new ObjectOutputStream(new FileOutputStream(currentDirectory + "suppliers.dat"))) {
            outputStream.writeObject(suppliers);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to save a supplier
    @Override
    public void save(Supplier model) {
        if (model.getId() <= 0) {
            // generate new id
            var newId = suppliers.keySet().stream().mapToInt(k -> k).max().orElse(0) + 1;
            suppliers.put(newId, model);
        } else {
            suppliers.put(model.getId(), model);
        }
        write();
    }

    public void update(){
        var currentDirectory = System.getProperty("user.dir") + "/src/main/resources/";

        try (var outputStream = new ObjectOutputStream(new FileOutputStream(currentDirectory + "suppliers.dat"))) {
            outputStream.writeObject(suppliers);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to delete a supplier
    @Override
    public void delete(Supplier model) {
        var currentDirectory = System.getProperty("user.dir") + "/src/main/resources/";

        try (var outputStream = new ObjectOutputStream(new FileOutputStream(currentDirectory + "suppliers.dat"))) {

            for (Iterator<Map.Entry<Integer, Supplier>> iterator = suppliers.entrySet().iterator(); iterator.hasNext(); ) {
                Map.Entry<Integer, Supplier> entry = iterator.next();
                if (entry.getValue().equals(model)) {
                    iterator.remove();
                    break;
                }
            }
            outputStream.writeObject(suppliers);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to get a supplier by id
    @Override
    public Supplier get(Integer id) {
        return suppliers.get(id);
    }

    // Method to get all suppliers
    @Override
    public Set<Supplier> getAll() {
        return Set.copyOf(suppliers.values());
    }
}
