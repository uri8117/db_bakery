package cat.uvic.teknos.db.bakery.repositories;

import cat.uvic.teknos.db.bakery.models.EmployeeProduct;
import java.util.Set;

// Interface for an employee product repository
public interface EmployeeProductRepository extends Repository<Integer, EmployeeProduct> {

    // Methods inherited from the Repository interface that must be implemented
    @Override
    void save(EmployeeProduct model);

    @Override
    void delete(EmployeeProduct model);

    @Override
    EmployeeProduct get(Integer id);

    @Override
    Set<EmployeeProduct> getAll();
}
