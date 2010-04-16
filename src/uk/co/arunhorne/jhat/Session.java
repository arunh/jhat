package uk.co.arunhorne.jhat;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Session {

    private static final AtomicInteger idGenerator = new AtomicInteger(0);
    private int id;
    private Map<String, Object> attributes;

    public Session() {
        id = idGenerator.getAndIncrement();
        attributes = new HashMap<String, Object>();
        System.out.println("Session created with id:" + id);
    }

    public int getId() {
        return id;
    }

    public void setAttribute(String name, Object value) {
        attributes.put(name, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Session session = (Session) o;

        return (id == session.id);
    }

    @Override
    public int hashCode() {
        return id;
    }
}
