package leetcode0635;

import java.util.HashMap;
import java.util.Map;

public class TimeStamp {
    private String[] priorities;
    private Map<String, String> map;

    TimeStamp(String timestamp) {
        priorities = new String[] {"Year", "Month", "Day", "Hour", "Minute", "Second"};
        map = new HashMap<>();
        map.put("Year", timestamp.substring(0, 4));
        map.put("Month", timestamp.substring(5, 7));
        map.put("Day", timestamp.substring(8, 10));
        map.put("Hour", timestamp.substring(11, 13));
        map.put("Minute", timestamp.substring(14, 16));
        map.put("Second", timestamp.substring(17, 19));
    }

    public int compareTo(TimeStamp other, String granularity) {
        for (String  name : priorities) {
            if (other.map.get(name).compareTo(this.map.get(name)) != 0) {
                int a = toInteger(this.map.get(name));
                int b = toInteger(other.map.get(name));
                return a - b;
            }

            if (name.equals(granularity)) break;
        }
        return 0;
    }

    private int toInteger(String val) {
        int res = 0;
        for (int i = 0; i < val.length(); i++) {
            res = res * 10 + Character.getNumericValue(val.charAt(i));
        }
        return res;
    }
}
