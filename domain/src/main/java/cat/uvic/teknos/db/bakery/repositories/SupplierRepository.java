package cat.uvic.teknos.db.bakery.repositories;

import cat.uvic.teknos.db.bakery.models.Supplier;
import java.util.Set;

// Interface for a supplier repository
public interface SupplierRepository extends Repository<Integer, Supplier> {

    // Methods inherited from the Repository interface that must be implemented
    @Override
    void save(Supplier model);

    @Override
    void delete(Supplier model);

    @Override
    Supplier get(Integer id);

    @Override
    Set<Supplier> getAll();
}
