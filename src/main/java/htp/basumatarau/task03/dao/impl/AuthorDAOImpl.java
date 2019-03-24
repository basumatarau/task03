package htp.basumatarau.task03.dao.impl;

import htp.basumatarau.task03.beans.Author;
import htp.basumatarau.task03.dao.DAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class AuthorDAOImpl implements DAO<Integer, Author> {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void persist(Author entity) {
        try(Session session = sessionFactory.openSession()){
            session.save(entity);
        }
    }

    @Override
    public Author read(Integer integer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Author> read(Integer startingFrom, int numItems) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Author entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Author entity) {
        throw new UnsupportedOperationException();
    }
}
