package ru.job4j.di;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Context {
    private final Map<String, Object> ctx = new HashMap<>();

    public void reg(Class clazz) {
        Constructor[] constructors = clazz.getDeclaredConstructors();
        if (constructors.length > 1) {
            throw new IllegalStateException("Class has multiple constructors : " + clazz.getCanonicalName());
        }
        List<Object> args = new ArrayList<>();
        for (Class param : constructors[0].getParameterTypes()) {
            if (!ctx.containsKey(param.getCanonicalName())) {
                throw new IllegalStateException("Object doesn't found in context : " + param.getCanonicalName());
            }
            args.add(ctx.get(param.getCanonicalName()));
        }
        try {
            ctx.put(clazz.getCanonicalName(), constructors[0].newInstance(args.toArray()));
        } catch (Exception e) {
            throw new IllegalStateException("Couldn't create an instance of : " + clazz.getCanonicalName(), e);
        }
    }

    public <T> T get(Class<T> inst) {
        return (T) ctx.get(inst.getCanonicalName());
    }
}
