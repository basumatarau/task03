package htp.basumatarau.task03.controller.view;

import htp.basumatarau.task03.beans.NewsItem;

import java.util.List;

public class PageView implements View<List<NewsItem>> {
    @Override
    public void render(List<NewsItem> list) {
        for (NewsItem newsItem : list) {
            out.println(String.format(
                    "ID:%d. %s published: %s, intro: %s", newsItem.getIdNewsItem(),
                    newsItem.getTitle(), newsItem.getPublicationDate().toString(),
                    newsItem.getIntro()
            ));
        }
    }
}
