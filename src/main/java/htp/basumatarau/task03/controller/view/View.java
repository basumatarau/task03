package htp.basumatarau.task03.controller.view;

import htp.basumatarau.task03.controller.Model;

import java.io.PrintStream;

public interface View {
    PrintStream out = System.out;
    void render(Model model);
}
