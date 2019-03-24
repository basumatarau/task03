package htp.basumatarau.task03;

import htp.basumatarau.task03.beans.Author;
import htp.basumatarau.task03.beans.NewsCategory;
import htp.basumatarau.task03.beans.NewsItem;
import htp.basumatarau.task03.beans.Tag;
import htp.basumatarau.task03.dao.impl.AuthorDAOImpl;
import htp.basumatarau.task03.dao.impl.NewsCategoryDAOImpl;
import htp.basumatarau.task03.dao.impl.NewsItemDAOImpl;
import htp.basumatarau.task03.dao.impl.TagDAOImpl;
import htp.basumatarau.task03.service.impl.NewsServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        context.getBean("TagDAO", TagDAOImpl.class).persist(t1);
        context.getBean("TagDAO", TagDAOImpl.class).persist(t2);
        context.getBean("AuthorDAO", AuthorDAOImpl.class).persist(a1);
        context.getBean("AuthorDAO", AuthorDAOImpl.class).persist(a2);
        context.getBean("NewsCategoryDAO", NewsCategoryDAOImpl.class).persist(newsCategory);

        context.getBean("defaultNewsServiceImpl", NewsServiceImpl.class).persistNewsItem(newsItem);
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

    @Test
    public void newsItemDAOTest03(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        NewsServiceImpl defaultNewsServiceImpl = context.getBean("defaultNewsServiceImpl", NewsServiceImpl.class);
        NewsItem ni = defaultNewsServiceImpl.getNewsItem(1);
        System.out.println(ni.getAuthorSet());
    }

}
