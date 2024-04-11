package cat.uvic.teknos.db.bakery.repositories;

import cat.uvic.teknos.db.bakery.models.Order;
import java.util.Set;

// Interface for an order repository
public interface OrderRepository extends Repository<Integer, Order> {

    // Methods inherited from the Repository interface that must be implemented
    @Override
    void save(Order model);

    @Override
    void delete(Order model);

    @Override
    Order get(Integer id);

    @Override
    Set<Order> getAll();
}
