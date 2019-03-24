package htp.basumatarau.task03.dao.impl;

import htp.basumatarau.task03.beans.NewsCategory;
import htp.basumatarau.task03.dao.DAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class NewsCategoryDAOImpl implements DAO<Integer, NewsCategory> {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void persist(NewsCategory entity) {
        try(Session session = sessionFactory.openSession()){
            session.save(entity);
        }
    }

    @Override
    public NewsCategory read(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<NewsCategory> read(Integer startingFrom, int numItems) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(NewsCategory entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(NewsCategory entity) {
        throw new UnsupportedOperationException();
    }
}
