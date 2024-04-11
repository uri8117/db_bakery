package cat.uvic.teknos.db.bakery.repositories;

import cat.uvic.teknos.db.bakery.models.Employee;
import java.util.Set;

// Interface for an employee repository
public interface EmployeeRepository extends Repository<Integer, Employee> {

    // Methods inherited from the Repository interface that must be implemented
    @Override
    void save(Employee model);

    @Override
    void delete(Employee model);

    @Override
    Employee get(Integer id);

    @Override
    Set<Employee> getAll();

    // Method specific for searching an employee by name
    Employee getByName(String name);
}
