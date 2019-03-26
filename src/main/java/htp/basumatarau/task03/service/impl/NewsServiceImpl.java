package htp.basumatarau.task03.service.impl;

import htp.basumatarau.task03.beans.NewsItem;
import htp.basumatarau.task03.dao.DAO;
import htp.basumatarau.task03.service.NewsService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NewsServiceImpl implements NewsService<NewsItem, Integer> {
    private DAO<Integer, NewsItem> newsItemDAO;

    public DAO<Integer, NewsItem> getNewsItemDAO() {
        return newsItemDAO;
    }

    public void setNewsItemDAO(DAO<Integer, NewsItem> newsItemDAO) {
        this.newsItemDAO = newsItemDAO;
    }

    public NewsServiceImpl(){}

    @Override
    public void persistNewsItem(NewsItem entity) {
        newsItemDAO.persist(entity);
    }

    @Override
    public NewsItem getNewsItem(Integer id) {
        return newsItemDAO.read(id);
    }

    @Override
    public List<NewsItem> getNewsItems(Integer starting, int numEntries) {
        return newsItemDAO.read(starting, numEntries);
    }

    @Override
    public void update(NewsItem entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(NewsItem entity) {
        newsItemDAO.delete(entity);
    }
}
