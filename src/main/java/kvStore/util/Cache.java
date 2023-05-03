package kvStore.util;

import java.util.LinkedHashMap;
import java.util.Map;

/*
Author : Srinivas A
This class provided functions to do operations on cache
 */

public class Cache {
    private static final int CAPACITY = 50;
    private static final LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>(CAPACITY,
            0.75f, true) {
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > CAPACITY;
        }
    };

    public static Object get(String key) {
        return map.getOrDefault(key, null);
    }

    public static void set(String key, Object value) {
        map.put(key, value);
    }

    public static void delete(String key){
        map.remove(key);
    }

}
