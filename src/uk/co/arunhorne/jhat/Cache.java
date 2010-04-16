package uk.co.arunhorne.jhat;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Cache {

    private Map<Integer, Cacheable> cache;

    public void reload() {
        final int ITEM_COUNT = 5;
        Map<Integer, Cacheable> newCache = new HashMap<Integer, Cacheable>(5);
        for (int i = 0 ; i < ITEM_COUNT; i++) {
            Cacheable item = new Cacheable(i);
            newCache.put(item.getPrimaryKey(), item);
        }
        System.out.printf("Cache reloaded, old=[%s] -> new=[%s]\n", cache, newCache);
        cache = newCache;

    }

    public Collection<Cacheable> select() {
        Collection<Cacheable> results = Collections.unmodifiableCollection(cache.values());
        System.out.println("Cache select returning: " + results);
        return results;
    }

}
