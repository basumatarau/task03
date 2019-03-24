package htp.basumatarau.task03.dao.impl;

import htp.basumatarau.task03.beans.Tag;
import htp.basumatarau.task03.dao.DAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class TagDAOImpl implements DAO<Integer, Tag> {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void persist(Tag entity) {
        try(Session session = sessionFactory.openSession()){
            session.save(entity);
        }
    }

    @Override
    public Tag read(Integer integer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Tag> read(Integer startingFrom, int numItems) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Tag entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Tag entity) {
        throw new UnsupportedOperationException();
    }
}
