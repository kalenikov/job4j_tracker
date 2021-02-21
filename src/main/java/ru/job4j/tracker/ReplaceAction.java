package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id for edit: ");
        String name = input.askStr("Enter new item name: ");
        Item newItem = new Item(name);
        return tracker.replace(id, newItem);
    }
}
