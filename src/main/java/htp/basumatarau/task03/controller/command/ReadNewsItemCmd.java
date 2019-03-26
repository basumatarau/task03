package htp.basumatarau.task03.controller.command;

import htp.basumatarau.task03.beans.NewsItem;
import htp.basumatarau.task03.controller.Model;
import htp.basumatarau.task03.controller.Param;
import htp.basumatarau.task03.controller.ParamResolver;
import htp.basumatarau.task03.service.NewsService;
import htp.basumatarau.task03.service.impl.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class ReadNewsItemCmd extends Command {

    ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");

    private NewsService<NewsItem, Integer> defaultNewsServiceImpl
            = context.getBean("defaultNewsServiceImpl", NewsServiceImpl.class);

    @Override
    public Command execute(String request, Model model) {
        Param param = ParamResolver.resolve(request);
        Integer id = param.get("id");

        NewsItem newsItem = defaultNewsServiceImpl.getNewsItem(id==null? 1: id);
        model.getMap().put("newsItem", newsItem);
        return null;
    }
}
