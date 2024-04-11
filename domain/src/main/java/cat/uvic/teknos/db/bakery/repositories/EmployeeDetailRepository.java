package cat.uvic.teknos.db.bakery.repositories;

import cat.uvic.teknos.db.bakery.models.EmployeeDetail;
import java.util.Set;

// Interface for an employee detail repository
public interface EmployeeDetailRepository extends Repository<Integer, EmployeeDetail> {

    // Methods inherited from the Repository interface that must be implemented
    @Override
    void save(EmployeeDetail model);

    @Override
    void delete(EmployeeDetail model);

    @Override
    EmployeeDetail get(Integer id);

    @Override
    Set<EmployeeDetail> getAll();
}
