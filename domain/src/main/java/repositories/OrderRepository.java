package repositories;

import cat.uvic.teknos.db.bakery.models.Order;

import java.util.Set;

public interface OrderRepository extends Repository<Integer, Order>{
    @Override
    void save(Order model);

    @Override
    void delete(Order model);

    @Override
    Order get(Integer id);

    @Override
    Set<Order> getAll();
}
