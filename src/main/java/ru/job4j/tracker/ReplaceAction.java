package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Edit item ====");
        int id = input.askInt("Enter id for edit: ");
        String name = input.askStr("Enter new item name: ");
        Item newItem = new Item(name);
        if (tracker.replace(id, newItem)) {
            out.println("The operation was successful");
        } else {
            out.println("The item with this id was not found");
        }
        return true;
    }
}
