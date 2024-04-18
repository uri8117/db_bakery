package cat.uvic.teknos.dbbakery.file.repositories;

import uvic.teknos.dbbakery.file.models.Client;
import org.junit.jupiter.api.Test;
import uvic.teknos.dbbakery.file.repositories.ClientRepository;

import static org.junit.jupiter.api.Assertions.*;

class ClientRepositoryTest {

    @Test
    void save() {

        // Define the path to the data file
        var path = System.getProperty("user.dir") + "/src/main/resources/clients.ser/";

        // Create an instance of the repository
        var repository = new ClientRepository(/*path*/);

        // Create a test client
        var client = new Client();
        client.setId(1);
        client.setName("John Doe");
        client.setEmail("john@example.com");
        client.setAddress("123 Main St");
        client.setPhone("555-1234");

        // Save the client
        repository.save(client);

        // Assert that the client ID is greater than 0 after saving
        assertTrue(client.getId() > 0);

        // Assert that the saved client can be retrieved
        assertNotNull(repository.get(client.getId()));

        // Load data from file
        ClientRepository.load();

        // Assert that the client can still be retrieved after loading data
        assertNotNull(repository.get(client.getId()));
    }

    @Test
    void update() {
        // Define the path to the data file
        var path = System.getProperty("user.dir") + "/src/main/resources/clients.ser/";

        // Create an instance of the repository
        var repository = new ClientRepository(/*path*/);

        // Create a test client
        var client = new Client();
        client.setId(1);
        client.setName("Andrew Tate");
        client.setEmail("Andrew@notmoreexample.com");
        client.setAddress("321 Street");
        client.setPhone("666-999");

        // Save the client
        repository.save(client);

        // Retrieve the client from the repository
        var updatedClient = repository.get(1);

        // Update the client's name
        updatedClient.setName("Updated Name");

        // Save the updated client
        repository.save(updatedClient);

        // Retrieve the client again
        var retrievedClient = repository.get(1);

        // Assert that the client's name has been updated
        assertEquals("Updated Name", retrievedClient.getName());
    }

    @Test
    void delete() {
        // Define the path to the data file
        var path = System.getProperty("user.dir") + "/src/main/resources/clients.ser/";

        // Create an instance of the repository
        var repository = new ClientRepository(/*path*/);

        // Create a test client
        var client = new Client();

        // Delete the client
        repository.delete(client);

        // Assert that the client has been deleted
        assertNull(repository.get(client.getId()));
    }
}