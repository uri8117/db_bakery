package uvic.teknos.dbbakery.file.repositories;

import cat.uvic.teknos.db.bakery.models.Client;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Implementation of the ClientRepository interface
public class ClientRepository implements cat.uvic.teknos.db.bakery.repositories.ClientRepository {
    // Static map to store clients
    private static Map<Integer, Client> clients = new HashMap<>();

    /*private final String path;

    public ClientRepository(String path) {
        this.path = path;

        load();
    }*/

    // Method to load clients from file
    public static void load() {
        var currentDirectory = System.getProperty("user.dir") + "/src/main/resources/";

        try(var inputStream = new ObjectInputStream(new FileInputStream(currentDirectory + "clients.ser"))) {
            clients = (Map<Integer, Client>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to write clients to file
    public void write() {
        var currentDirectory = System.getProperty("user.dir") + "/src/main/resources/";

        try(var outputStream = new ObjectOutputStream(new FileOutputStream(currentDirectory + "clients.ser"))) {
            outputStream.writeObject(clients);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to save a client
    @Override
    public void save(Client model) {
        if (model.getId() <= 0) {
            var newId = clients.keySet().stream().mapToInt(k -> k).max().orElse(0) + 1;
            //model.setId(newId);

            clients.put(newId, model);
        } else {
            /*if (clients.get(model.getId()) == null) {
                throw new RuntimeException("Client with id " + model.getId() + " not found");
            }*/
            clients.put(model.getId(), model);
        }
        write();
    }

    public void update(){
        var currentDirectory = System.getProperty("user.dir") + "/src/main/resources/";

        try (var outputStream = new ObjectOutputStream(new FileOutputStream(currentDirectory + "clients.ser"))) {
            outputStream.writeObject(clients);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to delete a client
    @Override
    public void delete(Client model) {

        var currentDirectory = System.getProperty("user.dir") + "/src/main/resources/";

        try (var outputStream = new ObjectOutputStream(new FileOutputStream(currentDirectory + "clients.ser"))) {

            for (Iterator<Map.Entry<Integer, Client>> iterator = clients.entrySet().iterator(); iterator.hasNext(); ) {
                Map.Entry<Integer, Client> entry = iterator.next();
                if (entry.getValue().equals(model)) {
                    iterator.remove();
                    break;
                }
            }

            outputStream.writeObject(clients);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to get a client by id
    @Override
    public Client get(Integer id) {
        return clients.get(id);
    }

    // Method to get all clients
    @Override
    public Set<Client> getAll() {
        return Set.copyOf(clients.values());
    }

    // Method to get a client by name
    @Override
    public Client getByName(String name) {
        for (Client client : clients.values()) {
            if (client.getName().equals(name)) {
                return client;
            }
        }
        return null;
    }
}