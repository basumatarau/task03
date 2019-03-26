package htp.basumatarau.task03.controller.command;

import htp.basumatarau.task03.controller.Model;

public abstract class Command {

    public abstract Command execute(String request, Model model);
}
