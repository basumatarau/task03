package htp.basumatarau.task03.dao;

import java.io.Serializable;
import java.util.List;

public interface DAO<Id extends Serializable, T> {
    void persist(T entity);
    T read(Id id);
    List<T> read(Id startingFrom, int numItems);
    void update(T entity);
    void delete(T entity);
}
