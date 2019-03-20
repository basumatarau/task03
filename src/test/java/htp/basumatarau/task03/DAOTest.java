package htp.basumatarau.task03;

import htp.basumatarau.task03.beans.Author;
import htp.basumatarau.task03.beans.NewsCategory;
import htp.basumatarau.task03.beans.NewsItem;
import htp.basumatarau.task03.beans.Tag;
import htp.basumatarau.task03.dao.impl.NewsItemDAOImpl;
import org.junit.Test;

import java.util.HashSet;

public class DAOTest {

    @Test
    public void newsItemDAOTest01(){
        HashSet<Author> authors = new HashSet<>();
        Author a1 = new Author();
        Author a2 = new Author();
        authors.add(a1);
        authors.add(a2);

        HashSet<Tag> tags = new HashSet<>();
        Tag t1 = new Tag();
        Tag t2 = new Tag();
        tags.add(t1);
        tags.add(t2);

        NewsCategory newsCategory = new NewsCategory();
        newsCategory.setCategoryName("test category");
        newsCategory.setIdCategory(1);

        NewsItem newsItem = new NewsItem();
        newsItem.setBody("test body bla bla bla");
        newsItem.setTitle("test title");
        newsItem.setIntro("test intro");
        newsItem.setAuthorSet(authors);
        newsItem.setTagSet(tags);
        newsItem.setCategory(newsCategory);

        NewsItemDAOImpl newsItemDAO = new NewsItemDAOImpl();
        newsItemDAO.persist(newsItem);
    }

}
