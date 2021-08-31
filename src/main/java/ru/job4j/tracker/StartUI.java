package ru.job4j.tracker;

import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Output out = new ConsoleOutput();
        Input input = new ValidateInput(out, new ConsoleInput());
//        MemTracker tracker = MemTracker.getInstance();
//        Store tracker = SqlTracker.getInstance();
        Store tracker = HbmTracker.getInstance();
        List<UserAction> actions = List.of(
                new CreateAction(out),
                new ReplaceAction(out),
                new DeleteAction(out),
                new FindItemByIdAction(out),
                new FindItemByNameAction(out),
                new ShowAllAction(out),
                new Exit()
        );
        new StartUI(out).init(input, tracker, actions);
    }
}
