package uvic.teknos.dbbakery.file.models;

public class Employee implements cat.uvic.teknos.db.bakery.models.Employee {
    // Attributes of the class
    private int id;
    private String name;
    private String position;

    // Methods to get and set the employee's ID
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    // Methods to get and set the employee's name
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    // Methods to get and set the employee's position
    @Override
    public String getPosition() {
        return position;
    }

    @Override
    public void setPosition(String position) {
        this.position = position;
    }
}
