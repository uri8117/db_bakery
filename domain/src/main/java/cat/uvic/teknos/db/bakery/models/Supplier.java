package cat.uvic.teknos.db.bakery.models;

// Interface that defines the contract to represent a supplier in the application
public interface Supplier {

    // Method to get the supplier's ID
    int getId();

    // Method to set the supplier's ID
    void setId(int id);

    // Method to get the supplier's name
    String getName();

    // Method to set the supplier's name
    void setName(String name);

    // Method to get the supplier's address
    String getAddress();

    // Method to set the supplier's address
    void setAddress(String address);

    // Method to get the supplier's phone number
    String getPhone();

    // Method to set the supplier's phone number
    void setPhone(String phone);
}
