package cat.uvic.teknos.db.bakery.repositories;

import cat.uvic.teknos.db.bakery.models.EmployeeOrder;
import java.util.Set;

// Interface for an employee order repository
public interface EmployeeOrderRepository extends Repository<Integer, EmployeeOrder> {

    // Methods inherited from the Repository interface that must be implemented
    @Override
    void save(EmployeeOrder model);

    @Override
    void delete(EmployeeOrder model);

    @Override
    EmployeeOrder get(Integer id);

    @Override
    Set<EmployeeOrder> getAll();
}
