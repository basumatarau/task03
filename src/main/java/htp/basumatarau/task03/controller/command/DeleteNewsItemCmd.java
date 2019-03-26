package htp.basumatarau.task03.controller.command;

import htp.basumatarau.task03.beans.NewsItem;
import htp.basumatarau.task03.controller.Model;
import htp.basumatarau.task03.service.NewsService;
import htp.basumatarau.task03.service.impl.NewsServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeleteNewsItemCmd extends Command{

    ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");

    private NewsService<NewsItem, Integer> defaultNewsServiceImpl
            = context.getBean("defaultNewsServiceImpl", NewsServiceImpl.class);

    public void setDefaultNewsServiceImpl(NewsService<NewsItem, Integer> defaultNewsServiceImpl) {
        this.defaultNewsServiceImpl = defaultNewsServiceImpl;
    }

    @Override
    public Command execute(String request, Model model) {
        defaultNewsServiceImpl.delete(((NewsItem) model.getMap().get("newsItem")));
        return null;
    }
}
