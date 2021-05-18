package ru.job4j.tracker;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;

public class ConnectionInvocationHandler implements InvocationHandler {
    private Connection connection;

    public ConnectionInvocationHandler(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("close".equals(method.getName())) {
            connection.rollback();
            connection.close();
            return null;
        } else {
            return method.invoke(connection, args);
        }
    }
}