package htp.basumatarau.task03.dao.impl;

import htp.basumatarau.task03.beans.Author;
import htp.basumatarau.task03.dao.DAO;

import java.util.List;

public class AuthorDAOImpl extends BaseDAO implements DAO<Integer, Author> {
    @Override
    public void persist(Author entity) {
        openCurrentSessionWithTransaction().save(entity);
        closeCurrenSessionWithTransaction();
    }

    @Override
    public Author read(Integer integer) {
        return null;
    }

    @Override
    public List<Author> read(Integer startingFrom, int numItems) {
        return null;
    }

    @Override
    public void update(Author entity) {

    }

    @Override
    public void delete(Author entity) {

    }
}
