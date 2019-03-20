package htp.basumatarau.task03.dao.impl;

import htp.basumatarau.task03.beans.NewsItem;
import htp.basumatarau.task03.dao.DAO;
import org.hibernate.query.Query;

import java.util.List;

public class NewsItemDAOImpl
        extends BaseDAO implements DAO<Integer, NewsItem> {
    @Override
    public void persist(NewsItem entity) {
        openCurrentSessionWithTransaction().save(entity);
        closeCurrenSessionWithTransaction();
    }

    @Override
    public NewsItem read(Integer id) {
        openCurrentSession();

        Query<NewsItem> query = getCurrentSession().createQuery("from NewsItem ni " +
                "join fetch ni.category " +
                "join fetch ni.tagSet " +
                "join fetch ni.authorSet " +
                "where ni.idNewsItem=:id ", NewsItem.class);

        query.setParameter("id", id);
        NewsItem singleResult = query.getSingleResult();
        closeCurrentSession();
        return singleResult;
    }

    @Override
    public List<NewsItem> read(Integer startingFrom, int numItems) {
        return null;
    }

    @Override
    public void update(NewsItem entity) {

    }

    @Override
    public void delete(NewsItem entity) {

    }
}
