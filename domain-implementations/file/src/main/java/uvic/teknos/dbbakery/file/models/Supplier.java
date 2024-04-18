package uvic.teknos.dbbakery.file.models;

import java.io.Serializable;

public class Supplier implements cat.uvic.teknos.db.bakery.models.Supplier, Serializable {
    // Attributes of the class
    private int id;
    private String name;
    private String address;
    private String phone;

    // Methods to get and set the supplier's ID
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    // Methods to get and set the supplier's name
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    // Methods to get and set the supplier's address
    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    // Methods to get and set the supplier's phone number
    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
