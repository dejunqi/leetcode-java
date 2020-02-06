package googleInterview.timedhashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapWithExpirationTime {

    private class Value {
        int val;
        long time;
        Value(int v, long t) {
            val = v;
            time = t;
        }
    }

    private Map<Integer, Value> map;
    public HashMapWithExpirationTime() {
        map = new HashMap<>();
    }

    public void put(int key, int value, long expirationTime) {
        long expiration = System.currentTimeMillis() + expirationTime;
        map.put(key, new Value(value, expiration));
    }

    public Integer get(int key) {
        if (!map.containsKey(key)) {
            return null;
        }

        long curtime = System.currentTimeMillis();
        if (map.get(key).time > curtime) {
            return map.get(key).val;
        }
        map.remove(key);
        return null;
    }

}
