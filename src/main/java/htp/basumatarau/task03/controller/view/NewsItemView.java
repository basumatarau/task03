package htp.basumatarau.task03.controller.view;

import htp.basumatarau.task03.beans.NewsItem;
import htp.basumatarau.task03.controller.Model;

public class NewsItemView implements View {
    @Override
    public void render(Model model) {
        NewsItem newsItem = (NewsItem) model.getMap().get("newsItem");
        if(newsItem == null){
            return;
        }
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
