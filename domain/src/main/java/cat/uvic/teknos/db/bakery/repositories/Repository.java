package cat.uvic.teknos.db.bakery.repositories;

import java.util.Set;

public interface Repository<K, V> {
    void save(V model);
    void delete(V model);
    V get(K id);
    Set<V> getAll();
}
