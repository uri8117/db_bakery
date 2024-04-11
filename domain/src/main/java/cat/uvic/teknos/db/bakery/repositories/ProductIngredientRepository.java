package cat.uvic.teknos.db.bakery.repositories;

import cat.uvic.teknos.db.bakery.models.ProductIngredient;
import java.util.Set;

// Interface for a product ingredient repository
public interface ProductIngredientRepository extends Repository<Integer, ProductIngredient> {

    // Methods inherited from the Repository interface that must be implemented
    @Override
    void save(ProductIngredient model);

    @Override
    void delete(ProductIngredient model);

    @Override
    ProductIngredient get(Integer id);

    @Override
    Set<ProductIngredient> getAll();
}
