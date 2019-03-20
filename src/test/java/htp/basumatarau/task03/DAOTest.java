package htp.basumatarau.task03;

import htp.basumatarau.task03.beans.Author;
import htp.basumatarau.task03.beans.NewsCategory;
import htp.basumatarau.task03.beans.NewsItem;
import htp.basumatarau.task03.beans.Tag;
import htp.basumatarau.task03.dao.impl.AuthorDAOImpl;
import htp.basumatarau.task03.dao.impl.NewsCategoryDAOImpl;
import htp.basumatarau.task03.dao.impl.NewsItemDAOImpl;
import htp.basumatarau.task03.dao.impl.TagDAOImpl;
import org.junit.Test;

import java.util.HashSet;

public class DAOTest {

    @Test
    public void newsItemDAOTest01(){
        HashSet<Author> authors = new HashSet<>();
        Author a1 = new Author();
        a1.setIdAuthor(1);
        a1.setAuthor("test author1");
        Author a2 = new Author();
        a2.setIdAuthor(2);
        a2.setAuthor("test author2");
        authors.add(a1);
        authors.add(a2);

        HashSet<Tag> tags = new HashSet<>();
        Tag t1 = new Tag();
        t1.setIdTag(1);
        t1.setTag("test tag1");
        Tag t2 = new Tag();
        t2.setIdTag(2);
        t2.setTag("test tag2");
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

        TagDAOImpl tagDAO = new TagDAOImpl();
        AuthorDAOImpl authorDAO = new AuthorDAOImpl();
        NewsCategoryDAOImpl newsCategoryDAO = new NewsCategoryDAOImpl();
        NewsItemDAOImpl newsItemDAO = new NewsItemDAOImpl();

        tagDAO.persist(t1);
        tagDAO.persist(t2);
        authorDAO.persist(a1);
        authorDAO.persist(a2);
        newsCategoryDAO.persist(newsCategory);

        newsItemDAO.persist(newsItem);
    }

    @Test
    public void newsItemDAOTest02(){
        NewsItemDAOImpl newsItemDAO = new NewsItemDAOImpl();
        NewsItem item = newsItemDAO.read(1);
        System.out.println(item.getBody());
        System.out.println(item.getCategory().getCategoryName());
        System.out.println(item.getTagSet());
        System.out.println(item.getAuthorSet());
    }
}
