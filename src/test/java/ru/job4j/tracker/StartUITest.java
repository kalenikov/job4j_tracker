package ru.job4j.tracker;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    private static Connection cn;
    private static Store tracker;

    @BeforeClass
    public static void init() throws SQLException {
        try (InputStream in = StartUITest.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        tracker = new SqlTracker(ConnectionRollbackProxy.create(cn));
    }

    @After
    public void clearTracker() {
        MemTracker.getInstance().clear();
        ((SqlTracker) tracker).clear();
    }

    @Test
    public void whenCreateItem() throws SQLException {
        Output out = new StubOutput();
        Input in = new StubInput(List.of("0", "Item name", "1"));
        List<UserAction> actions = List.of(
                new CreateAction(out),
                new Exit()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("item1"));
    }


    @Test
    public void whenReplaceItem() throws SQLException {
        Output out = new StubOutput();
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
    public void whenDeleteItem() throws SQLException {
        Output out = new StubOutput();
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
    public void whenExit() throws SQLException {
        Output out = new StubOutput();
        Input in = new StubInput(List.of("0"));
        List<UserAction> actions = List.of(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindById() throws SQLException {
        Output out = new StubOutput();
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
    public void whenShowAll() throws SQLException {
        Output out = new StubOutput();
        Input in = new StubInput(List.of("0", "1"));
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
    public void whenFindByName() throws SQLException {
        Output out = new StubOutput();
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
    public void whenInvalidExit() throws SQLException {
        Output out = new StubOutput();
        Input in = new StubInput(List.of("10", "0"));
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