package htp.basumatarau.task03.controller.view;

import htp.basumatarau.task03.controller.Model;

public class PromptView implements View {

    @Override
    public void render(Model model) {
        out.println(model.getMap().get("prompt"));
    }
}
