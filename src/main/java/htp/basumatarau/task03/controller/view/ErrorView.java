package htp.basumatarau.task03.controller.view;

import htp.basumatarau.task03.controller.Model;

public class ErrorView implements View {
    @Override
    public void render(Model model) {

        out.println("error has occurred: " + model.getMap().get("errorMessage"));
    }
}
