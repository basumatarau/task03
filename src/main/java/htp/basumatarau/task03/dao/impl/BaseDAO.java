package htp.basumatarau.task03.dao.impl;

import htp.basumatarau.task03.beans.Author;
import htp.basumatarau.task03.beans.NewsCategory;
import htp.basumatarau.task03.beans.NewsItem;
import htp.basumatarau.task03.beans.Tag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BaseDAO {
    private static SessionFactory sessionFactory;
    private Session currentSession;
    private Transaction currentTransaction;

    private SessionFactory getSessionFactory(){
        if(sessionFactory == null) {
            synchronized (BaseDAO.class) {
                if (sessionFactory == null) {
                    sessionFactory
                            = new Configuration().configure("hibernate.cfg.xml")
                            .addAnnotatedClass(Author.class)
                            .addAnnotatedClass(NewsCategory.class)
                            .addAnnotatedClass(NewsItem.class)
                            .addAnnotatedClass(Tag.class)
                            .buildSessionFactory();
                }
            }
        }
        return sessionFactory;
    }

    protected Session openCurrentSession(){
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
    protected Session openCurrentSessionWithTransaction(){
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
    protected void closeCurrentSession(){
        currentSession.close();
    }
    protected void closeCurrenSessionWithTransaction(){
        currentTransaction.commit();
        currentSession.close();
    }

    protected Session getCurrentSession(){
        return currentSession;
    }
    protected Transaction getCurrentTransaction(){
        return currentTransaction;
    }
}
