package ru.job4j.tracker;

public class FindItemByIdAction implements UserAction{
    @Override
    public String name() {
        return "=== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id to search for: ");
        Item item = tracker.findById(id);
        return item != null;
    }
}
