package htp.basumatarau.task03.controller.view;

import java.io.PrintStream;

public interface View<T> {
    PrintStream out = System.out;
    void render(T entity);
}
