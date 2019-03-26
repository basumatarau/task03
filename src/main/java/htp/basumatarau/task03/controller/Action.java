package htp.basumatarau.task03.controller;

import htp.basumatarau.task03.controller.command.*;
import htp.basumatarau.task03.controller.view.*;

public enum Action {
    LIST_NEWS_ITEMS{
        {
            name = "show-news";
            view = new PageView();
            cmd = new ReadNewsCmd();
        }
    },
    READ_NEWS_ITEM{
        {
            name = "show-item";
            view = new NewsItemView();
            cmd = new ReadNewsItemCmd();
        }
    },
    DELETE_NEWS_ITEM{
        {
            name = "delete";
            view = new PromptView();
            cmd = new PromptCmd();
        }
    },
    RETURN_TO_BROWSING{
        {
            name = "return";
            view = new PageView();
            cmd = new ReadNewsCmd();
        }
    },
    CONFIRM_DELETE{
        {
            name = "yes";
            view = new PromptView();
            cmd = new DeleteNewsItemCmd();
        }
    },
    CALLBACK_DELETE{
        {
            name = "no";
            view = new PageView();
            cmd = new ReadNewsCmd();
        }
    },
    ERROR{
        {
            name = "error";
            view = new ErrorView();
            cmd = new ReadNewsCmd();
        }
    },
    TERMINATE{
        {
            name = "stop";
            view = new ErrorView();
            cmd = new ReadNewsCmd();
        }
    };

    Action() {
    }

    public String name;
    public View view;
    public Command cmd;
}
