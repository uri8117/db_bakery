package cat.uvic.teknos.db.bakery.models;

// Interface that defines the contract to represent a client in the application
public interface Client {

    // Method to get the client's ID
    int getId();

    // Method to set the client's ID
    void setId(int id);

    // Method to get the client's name
    String getName();

    // Method to set the client's name
    void setName(String name);

    // Method to get the client's email
    String getEmail();

    // Method to set the client's email
    void setEmail(String email);

    // Method to get the client's address
    String getAddress();

    // Method to set the client's address
    void setAddress(String address);

    // Method to get the client's phone number
    String getPhone();

    // Method to set the client's phone number
    void setPhone(String phone);
}
