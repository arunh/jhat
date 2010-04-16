package uk.co.arunhorne.jhat;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Container {

    private final Map<Integer, Session> sessions;
    private final Cache cache;

    public Container() {
        this.sessions = new HashMap<Integer, Session>();
        this.cache = new Cache();
        this.cache.reload();
        System.out.println("Container created, and waiting for requests...");
    }

    public int newUserSessionAndQuery() {
        System.out.println("User query received");
        Session session = createAndRegisterSession();
        Collection<Cacheable> queryResults = cache.select();
        System.out.println("Storing results on session: " + queryResults);
        session.setAttribute("queryResults", queryResults);
        return session.getId();
    }

    public void removeSession(int id) {
        System.out.println("Removing session: " + id);
        sessions.remove(id);
    }

    public void triggerReload() {
        System.out.println("Trigger reload received");
        cache.reload();
    }

    private Session createAndRegisterSession() {
        Session session = new Session();
        System.out.println("Registering session with container");
        sessions.put(session.getId(), session);
        return session;
    }

}
