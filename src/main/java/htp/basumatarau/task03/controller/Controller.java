package htp.basumatarau.task03.controller;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Controller {
    private static ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");

    private Model model = new Model();
    private static State state = State.BROWSING_NEWS;

    private enum State {
        BROWSING_NEWS {
            @Override
            void next(String request, Model model) {
                Action action = ActionResolver.resolve(request);
                switch (action) {
                    case LIST_NEWS_ITEMS:
                        action.cmd.execute(request, model);
                        state = BROWSING_NEWS;
                        break;
                    case READ_NEWS_ITEM:
                        action.cmd.execute(request, model);
                        state = READING_NEWS_ITEM;
                        break;
                    case TERMINATE:
                        state = TERMINAL;
                        break;
                    case ERROR:
                        state = BROWSING_NEWS;
                        model.getMap().put("errorMessage",
                                "select news item to read (cmd: show-item) or terminate (cmd: stop)");
                        break;
                    default:
                        state = BROWSING_NEWS;
                }
            }
        },
        READING_NEWS_ITEM {
            @Override
            void next(String request, Model model) {
                Action action = ActionResolver.resolve(request);
                switch (action) {
                    case DELETE_NEWS_ITEM:
                        model.getMap().put("prompt", "do you want to delete this piece of news? y/n");
                        state = PROMPTED;
                        break;
                    case RETURN_TO_BROWSING:
                        action.cmd.execute(request, model);
                        state = BROWSING_NEWS;
                        break;
                    case TERMINATE:
                        state = TERMINAL;
                        break;
                    case ERROR:
                        state = BROWSING_NEWS;
                        model.getMap().put("errorMessage",
                                "choose to delete the news item or return without deletion (cmd: delete/return) or terminate (cmd: stop)");
                        break;
                    default:
                        state = BROWSING_NEWS;
                }
            }
        },
        PROMPTED {
            @Override
            void next(String request, Model model) {
                Action action = ActionResolver.resolve(request);
                switch (action) {
                    case CONFIRM_DELETE:
                        action.cmd.execute(request, model);
                        model.getMap().put("prompt", "deleted successfully");
                        state = PROMPTED;
                        break;
                    case RETURN_TO_BROWSING:
                        action.cmd.execute(request, model);
                        state = BROWSING_NEWS;
                        break;
                    case TERMINATE:
                        state = TERMINAL;
                        break;
                    case ERROR:
                        state = PROMPTED;
                        model.getMap().put("errorMessage",
                                "confirm deletion of the news item (cmd: yes/no) or terminate (cmd: stop)");
                        break;
                    default:
                        action.cmd.execute(request, model);
                        state = BROWSING_NEWS;
                }
            }
        },
        TERMINAL;

        void next(String request, Model model) {
            throw new UnsupportedOperationException();
        }

        void renderView(String request, Model model) {
            ActionResolver
                    .resolve(request)
                    .view
                    .render(model);
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        while (state != State.TERMINAL) {
            String request = scanner.next();
            state.next(request, model);
            state.renderView(request, model);
        }
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.run();
    }
}
