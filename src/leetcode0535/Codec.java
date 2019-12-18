package leetcode0535;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Codec {

    private Map<String, String> map;
    private String base;
    Codec() {
        map = new HashMap<>();
        base = "http://tinyurl.com/";
    }


    public String encode(String longUrl) {
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int num = rnd.nextInt(256);
            sb.append(num);
        }
        String key = sb.toString();
        if (map.containsKey(key)) {
            return encode(longUrl);
        }

        map.put(key, longUrl);
        return base + key;
    }

    public String decode(String shortUrl) {
        String key = shortUrl.substring(base.length());
        return map.get(key);
    }
}
