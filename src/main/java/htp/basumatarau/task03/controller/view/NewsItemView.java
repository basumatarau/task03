package htp.basumatarau.task03.controller.view;

import htp.basumatarau.task03.beans.NewsItem;

public class NewsItemView implements View<NewsItem> {
    @Override
    public void render(NewsItem newsItem) {
        out.println(String.format(
                "ID:%d. title: %s, date: %s, intro: %s \n\n tags:%s\n authors:%s\n\n%s",
                newsItem.getIdNewsItem(),
                newsItem.getTitle(),
                newsItem.getPublicationDate().toString(),
                newsItem.getIntro(),
                newsItem.getTagSet(),
                newsItem.getAuthorSet(),
                newsItem.getBody()
        ));
    }
}
