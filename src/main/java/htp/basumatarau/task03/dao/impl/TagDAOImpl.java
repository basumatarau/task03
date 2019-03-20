package htp.basumatarau.task03.dao.impl;

import htp.basumatarau.task03.beans.Tag;
import htp.basumatarau.task03.dao.DAO;

import java.util.List;

public class TagDAOImpl extends BaseDAO implements DAO<Integer, Tag> {
    @Override
    public void persist(Tag entity) {
        openCurrentSessionWithTransaction().save(entity);
        closeCurrenSessionWithTransaction();
    }

    @Override
    public Tag read(Integer integer) {
        return null;
    }

    @Override
    public List<Tag> read(Integer startingFrom, int numItems) {
        return null;
    }

    @Override
    public void update(Tag entity) {

    }

    @Override
    public void delete(Tag entity) {

    }
}
