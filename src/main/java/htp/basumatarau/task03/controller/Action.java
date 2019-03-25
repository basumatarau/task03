package htp.basumatarau.task03.controller;

import htp.basumatarau.task03.controller.command.Command;
import htp.basumatarau.task03.controller.command.DeleteNewsItemCmd;
import htp.basumatarau.task03.controller.command.ReadNewsCmd;
import htp.basumatarau.task03.controller.command.ReadNewsItemCmd;
import htp.basumatarau.task03.controller.view.NewsItemView;
import htp.basumatarau.task03.controller.view.PageView;
import htp.basumatarau.task03.controller.view.PromptView;
import htp.basumatarau.task03.controller.view.View;

public enum Action {
    LIST_NEWS_ITEMS{
        {
            view = new PageView();
            cmd = new ReadNewsCmd();
        }
    },
    READ_NEWS_ITEM{
        {
            view = new NewsItemView();
            cmd = new ReadNewsItemCmd();
        }
    },
    DELETE_NEWS_ITEM{
        {
            view = new PromptView();
            cmd = new DeleteNewsItemCmd();
        }
    },
    ERROR{
        {
            view = new PageView();
            cmd = new ReadNewsCmd();
        }
    },
    TERMINATE;

    Action() {
    }

    public View view;
    public Command cmd;
}
