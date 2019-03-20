package htp.basumatarau.task03.dao.impl;

import htp.basumatarau.task03.beans.NewsCategory;
import htp.basumatarau.task03.dao.DAO;

import java.util.List;

public class NewsCategoryDAOImpl extends BaseDAO implements DAO<Integer, NewsCategory> {
    @Override
    public void persist(NewsCategory entity) {
        openCurrentSessionWithTransaction().save(entity);
        closeCurrenSessionWithTransaction();
    }

    @Override
    public NewsCategory read(Integer id) {
        return null;
    }

    @Override
    public List<NewsCategory> read(Integer startingFrom, int numItems) {
        return null;
    }

    @Override
    public void update(NewsCategory entity) {

    }

    @Override
    public void delete(NewsCategory entity) {

    }
}
