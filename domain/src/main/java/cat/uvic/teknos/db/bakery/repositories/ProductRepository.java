package cat.uvic.teknos.db.bakery.repositories;

import cat.uvic.teknos.db.bakery.models.Product;
import java.util.Set;

// Interface for a product repository
public interface ProductRepository extends Repository<Integer, Product> {

    // Methods inherited from the Repository interface that must be implemented
    @Override
    void save(Product model);

    @Override
    void delete(Product model);

    @Override
    Product get(Integer id);

    @Override
    Set<Product> getAll();
}
