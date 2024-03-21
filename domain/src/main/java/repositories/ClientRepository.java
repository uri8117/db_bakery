package repositories;

import cat.uvic.teknos.db.bakery.models.Client;

import java.util.Set;

public interface ClientRepository extends Repository<Integer, Client>{

    @Override
    void save(Client model);

    @Override
    void delete(Client model);

    @Override
    Client get(Integer id);

    @Override
    Set<Client> getAll();

    Client GetName(String name);
}
