package cat.uvic.teknos.db.bakery.repositories;

import cat.uvic.teknos.db.bakery.models.OrderItem;
import java.util.Set;

// Interface for an order item repository
public interface OrderItemRepository extends Repository<Integer, OrderItem> {

    // Methods inherited from the Repository interface that must be implemented
    @Override
    void save(OrderItem model);

    @Override
    void delete(OrderItem model);

    @Override
    OrderItem get(Integer id);

    @Override
    Set<OrderItem> getAll();
}
