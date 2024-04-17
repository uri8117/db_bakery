package uvic.teknos.dbbakery.file.models;

import java.io.Serializable;

public class Client implements cat.uvic.teknos.db.bakery.models.Client, Serializable {
    // Attributes of the class
    private int id;
    private String name;
    private String email;
    private String address;
    private String phone;

    // Methods to get and set the client's ID
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    // Methods to get and set the client's name
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    // Methods to get and set the client's email
    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    // Methods to get and set the client's address
    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    // Methods to get and set the client's phone number
    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
