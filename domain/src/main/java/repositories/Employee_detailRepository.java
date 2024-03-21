package repositories;

import cat.uvic.teknos.db.bakery.models.Employee_detail;

import java.util.Set;

public interface Employee_detailRepository extends Repository<Integer, Employee_detail>{
    @Override
    void save(Employee_detail model);

    @Override
    void delete(Employee_detail model);

    @Override
    Employee_detail get(Integer id);

    @Override
    Set<Employee_detail> getAll();
}
