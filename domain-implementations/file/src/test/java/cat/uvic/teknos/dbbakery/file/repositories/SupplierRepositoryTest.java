package cat.uvic.teknos.dbbakery.file.repositories;

import cat.uvic.teknos.dbbakery.file.models.Supplier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SupplierRepositoryTest {

    @Test
    void save() {

        // Define the path to the data file
        var path = System.getProperty("user.dir") + "/src/test/resources/suppliers.ser/";

        // Create an instance of the repository
        var supplierRepository = new SupplierRepository(path);

        // Create a test supplier
        var supplier = new Supplier();
        supplier.setId(1);
        supplier.setName("Joel Vila");
        supplier.setAddress("543 Street");
        supplier.setPhone("782-9383");

        // Save the supplier
        supplierRepository.save(supplier);

        // Assert that the supplier ID is greater than 0 after saving
        assertTrue(supplier.getId() > 0);

        // Assert that the saved supplier can be retrieved
        assertNotNull(supplierRepository.get(supplier.getId()));

        // Load data from file
        supplierRepository.load();

        // Assert that the supplier can still be retrieved after loading data
        assertNotNull(supplierRepository.get(supplier.getId()));
    }

    @Test
    void update() {
        // Define the path to the data file
        var path = System.getProperty("user.dir") + "/src/test/resources/suppliers.ser/";

        // Create an instance of the repository
        var repository = new SupplierRepository(path);

        // Create a test supplier
        var supplier = new Supplier();
        supplier.setId(1);
        supplier.setName("Martin Big");
        supplier.setAddress("18 Street");
        supplier.setPhone("777-923");

        // Save the supplier
        repository.save(supplier);

        // Retrieve the supplier from the repository
        var updatedSupplier = repository.get(1);

        // Update the supplier's name
        updatedSupplier.setName("Updated Name");

        // Save the updated supplier
        repository.save(updatedSupplier);

        // Retrieve the supplier again
        var retrievedSupplier = repository.get(1);

        // Assert that the supplier's name has been updated
        assertEquals("Updated Name", retrievedSupplier.getName());
    }

    @Test
    void delete() {
        // Define the path to the data file
        var path = System.getProperty("user.dir") + "/src/test/resources/suppliers.ser/";

        // Create an instance of the repository
        var repository = new SupplierRepository(path);

        // Create a test supplier
        var supplier = new Supplier();

        // Delete the supplier
        repository.delete(supplier);

        // Assert that the supplier has been deleted
        assertNull(repository.get(supplier.getId()));
    }
}
