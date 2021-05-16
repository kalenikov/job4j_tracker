package ru.job4j.tracker;

import org.junit.After;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @After
    public void clearTracker() {
        MemTracker.getInstance().clear();
    }

//    @Test
//    public void whenCreateItem() {
//        Output out = new StubOutput();
//        Input in = new StubInput(List.of("0", "Item name", "1"));
//        Tracker tracker = Tracker.getInstance();
//        List<UserAction> actions = List.of(
//                new CreateAction(out),
//                new Exit()
//        );
//        new StartUI(out).init(in, tracker, actions);
//        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
//    }


    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Store tracker = SqlTracker.getInstance();
        Item item = tracker.add(new Item("Replaced item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "New item name";
        Input in = new StubInput(
                List.of("0", String.valueOf(item.getId()), replacedName, "1"));
        List<UserAction> actions = List.of(
                new ReplaceAction(out),
                new Exit()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Store tracker = SqlTracker.getInstance();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        Input in = new StubInput(
                List.of("0", String.valueOf(item.getId()), "1")
        );
        List<UserAction> actions = List.of(
                new DeleteAction(out),
                new Exit()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(List.of("0"));
        Store tracker = SqlTracker.getInstance();
        List<UserAction> actions = List.of(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Store tracker = SqlTracker.getInstance();
        Item item = tracker.add(new Item("item1"));
        Input in = new StubInput(
                List.of("0", String.valueOf(item.getId()), "1"));
        List<UserAction> actions = List.of(
                new FindItemByIdAction(out),
                new Exit()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. === Find item by Id ====" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "=== Find item by Id ====" + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. === Find item by Id ====" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenShowAll() {
        Output out = new StubOutput();
        Input in = new StubInput(List.of("0", "1"));
        Store tracker = SqlTracker.getInstance();
        Item item1 = tracker.add(new Item("item1"));
        Item item2 = tracker.add(new Item("item2"));
        List<UserAction> actions = List.of(
                new ShowAllAction(out),
                new Exit()
        );
        String ln = System.lineSeparator();
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu."
                        + ln
                        + "0. === Show all items ===="
                        + ln
                        + "1. Exit"
                        + ln
                        + "=== Show all items ===="
                        + ln
                        + item1
                        + ln
                        + item2
                        + ln
                        + "Menu."
                        + ln
                        + "0. === Show all items ===="
                        + ln
                        + "1. Exit"
                        + ln
        ));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Store tracker = SqlTracker.getInstance();
        Item item = tracker.add(new Item("item1"));
        Input in = new StubInput(List.of("0", String.valueOf(item.getName()), "1"));
        List<UserAction> actions = List.of(
                new FindItemByNameAction(out),
                new Exit()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. === Find items by name ====" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "=== Find items by name ====" + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. === Find items by name ====" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(List.of("10", "0"));
        Store tracker = SqlTracker.getInstance();
        List<UserAction> actions = List.of(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. Exit%n"
                )
        ));
    }
}