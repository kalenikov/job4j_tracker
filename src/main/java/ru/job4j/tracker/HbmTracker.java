package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class HbmTracker implements Store {
    private static HbmTracker instance;
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
    private final SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();

    private HbmTracker() {
    }

    public static HbmTracker getInstance() {
        if (instance == null) {
            instance = new HbmTracker();
        }
        return instance;
    }

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.createQuery("update Item i set i.name = :name where i.id = :id")
                .setParameter("name", item.getName())
                .setParameter("id", id)
                .executeUpdate();
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(int id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Item item = new Item(null);
        item.setId(id);
        session.delete(item);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        session.beginTransaction();
        List result = session.createQuery("from Item").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public List<Item> findByName(String name) {
        Session session = sf.openSession();
        session.beginTransaction();
        List result = session
                .createQuery("from Item where name=:name")
                .setParameter("name", name)
                .list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public Item findById(int id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Item result = session
                .createQuery("from Item where id=:id", Item.class)
                .setParameter("id", id)
                .uniqueResult();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }

    @Override
    public void init() {
        Session session = sf.openSession();
        session.beginTransaction();
        session.createSQLQuery("truncate table items;").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

}
