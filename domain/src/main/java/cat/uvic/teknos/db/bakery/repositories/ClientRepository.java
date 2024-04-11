package cat.uvic.teknos.db.bakery.repositories;

import cat.uvic.teknos.db.bakery.models.Client;

import java.util.Set;

// Interface for a client repository
public interface ClientRepository extends Repository<Integer, Client> {

    // Methods inherited from the Repository interface that must be implemented
    @Override
    void save(Client model);

    @Override
    void delete(Client model);

    @Override
    Client get(Integer id);

    @Override
    Set<Client> getAll();

    // Method specific for searching a client by name
    Client getByName(String name);
}

