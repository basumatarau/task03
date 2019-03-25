package htp.basumatarau.task03.controller;

import htp.basumatarau.task03.controller.command.Command;
import htp.basumatarau.task03.controller.view.View;

public class FrontController {
    private ActionResolver actionResolver = new ActionResolver();
    public void handleRequest(String request){
        Action action = actionResolver.resolve(request);
        Command cmd = action.cmd;
        View view = action.view;

        Command nextCommand;

        try{
            nextCommand = cmd.execute(request);
        }catch (Exception e){
            nextCommand = null;
            view = Action.ERROR.view;
        }

        if(nextCommand == null || nextCommand == cmd){

        }
    }
}
