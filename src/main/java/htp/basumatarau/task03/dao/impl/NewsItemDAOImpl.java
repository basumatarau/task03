package htp.basumatarau.task03.dao.impl;

import htp.basumatarau.task03.beans.NewsItem;
import htp.basumatarau.task03.dao.DAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class NewsItemDAOImpl
        implements DAO<Integer, NewsItem> {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void persist(NewsItem entity) {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        }
    }

    @Override
    public NewsItem read(Integer id) {
        NewsItem singleResult;
        try(Session session = sessionFactory.openSession()){

            Query<NewsItem> query = session.createQuery("from NewsItem ni " +
                    "join fetch ni.category " +
                    "join fetch ni.tagSet " +
                    "join fetch ni.authorSet " +
                    "where ni.idNewsItem=:id ", NewsItem.class);

            query.setParameter("id", id);
            singleResult = query.getSingleResult();
            System.out.println(singleResult);
        }
        return singleResult;
    }

    @Override
    public List<NewsItem> read(Integer startingFrom, int numItems) {
        List<NewsItem> resultList;
        try(Session session = sessionFactory.openSession()){

            Query<NewsItem> query = session.createQuery("from NewsItem ni " +
                    "join fetch ni.category " +
                    "join fetch ni.tagSet " +
                    "join fetch ni.authorSet " +
                    "where ni.idNewsItem>:id ", NewsItem.class);

            query.setParameter("id", startingFrom);
            query.setMaxResults(numItems);
            resultList = query.getResultList();
        }
        return resultList;
    }

    @Override
    public void update(NewsItem entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(NewsItem entity) {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        }
    }
}
