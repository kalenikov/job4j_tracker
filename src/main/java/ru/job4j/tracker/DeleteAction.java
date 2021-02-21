package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Delete item ====");
        int id = input.askInt("Enter id for delete: ");
         if (tracker.delete(id)) {
            out.println("The operation was successful");
        } else {
            out.println("The item with this id was not found");
        }
         return true;
    }
}
