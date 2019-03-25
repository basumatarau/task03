package htp.basumatarau.task03.controller.view;

import htp.basumatarau.task03.beans.NewsItem;

public class PromptView implements View<NewsItem> {

    @Override
    public void render(NewsItem entity) {
        out.println("do you want to delete this piece of news? y/n");
    }
}
