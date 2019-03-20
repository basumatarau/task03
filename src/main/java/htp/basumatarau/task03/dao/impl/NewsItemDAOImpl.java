package htp.basumatarau.task03.dao.impl;

import htp.basumatarau.task03.beans.NewsItem;
import htp.basumatarau.task03.dao.DAO;

import java.util.List;

public class NewsItemDAOImpl
        extends BaseDAO implements DAO<Integer, NewsItem> {
    @Override
    public void persist(NewsItem entity) {
        openCurrentSessionWithTransaction().save(entity);
        closeCurrenSessionWithTransaction();
    }

    @Override
    public NewsItem read(Integer integer) {
        return null;
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
