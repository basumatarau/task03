package htp.basumatarau.task03.service;

import java.io.Serializable;
import java.util.List;

public interface NewsService <T, ID extends Serializable>{
    T getNewsItem(ID id);
    List<T> getNewsItems(ID starting, int numEntries);
    void persistNewsItem(T entity);
    void update(T entity);
    void delete(T entity);
}
