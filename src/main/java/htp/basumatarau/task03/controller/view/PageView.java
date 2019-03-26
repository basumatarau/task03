package htp.basumatarau.task03.controller.view;

import htp.basumatarau.task03.beans.NewsItem;
import htp.basumatarau.task03.controller.Model;

import java.util.List;

public class PageView implements View {
    @Override
    public void render(Model model) {
        List<NewsItem> list = (List<NewsItem>) model.getMap().get("list");
        for (NewsItem newsItem : list) {
            out.println(String.format(
                    "ID:%d. %s published: %s, intro: %s",
                    newsItem.getIdNewsItem(),
                    newsItem.getTitle(),
                    newsItem.getPublicationDate().toString(),
                    newsItem.getIntro()
            ));
        }
    }
}
