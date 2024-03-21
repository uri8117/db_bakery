package cat.uvic.teknos.db.bakery.models;

public interface Supplier {
    int getId();

    void setId(int id);

    String getName();

    void setId(String name);

    String getAddress();

    void setAddress(String address);

    String getPhone();

    void setPhone(String phone);
}
