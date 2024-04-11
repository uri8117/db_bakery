package cat.uvic.teknos.db.bakery.repositories;

import cat.uvic.teknos.db.bakery.models.Ingredient;
import java.util.Set;

// Interface for an ingredient repository
public interface IngredientRepository extends Repository<Integer, Ingredient> {

    // Methods inherited from the Repository interface that must be implemented
    @Override
    void save(Ingredient model);

    @Override
    void delete(Ingredient model);

    @Override
    Ingredient get(Integer id);

    @Override
    Set<Ingredient> getAll();
}
