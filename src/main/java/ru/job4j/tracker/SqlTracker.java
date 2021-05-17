package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class SqlTracker implements Store {
    private static SqlTracker instance;
    private Connection cn;

    private SqlTracker() {
    }

    public static SqlTracker getInstance() {
        if (instance == null) {
            instance = new SqlTracker();
            instance.init();
        }
        return instance;
    }

    @Override
    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
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
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement ps = cn.prepareStatement("insert into items(name) values(?)",
                Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, item.getName());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                item.setId(rs.getInt(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        try (PreparedStatement ps = cn.prepareStatement("update items set name=? where id=?")) {
            ps.setString(1, item.getName());
            ps.setInt(2, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try (PreparedStatement ps = cn.prepareStatement("delete from items where id=?")) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Item> findAll() {
        List<Item> rsl = new ArrayList<>();
        try (Statement ps = cn.createStatement()) {
            ps.executeQuery("select * from items order by id");
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                rsl.add(new Item(
                        rs.getInt("id"),
                        rs.getString("name")
                ));
            }
            return rsl;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        try (PreparedStatement ps = cn.prepareStatement("select * from items where name = ? order by id")) {
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                rsl.add(new Item(
                        rs.getInt("id"),
                        rs.getString("name")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rsl;
    }

    @Override
    public Item findById(int id) {
        try (PreparedStatement ps = cn.prepareStatement("select * from items where id = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Item(
                        rs.getInt("id"),
                        rs.getString("name")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }
}
