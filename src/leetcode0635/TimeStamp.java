package leetcode0635;

import java.util.HashMap;
import java.util.Map;

public class TimeStamp {

    private String[] priorities = {"Year", "Month", "Day", "Hour", "Minute", "Second"};
    private Map<String, String> map;

    public TimeStamp(String timestamp) {
        map = new HashMap<>();
        map.put("Year", timestamp.substring(0, 4));
        map.put("Month", timestamp.substring(5, 7));
        map.put("Day", timestamp.substring(8, 10));
        map.put("Hour", timestamp.substring(11, 13));
        map.put("Minute", timestamp.substring(14, 16));
        map.put("Second", timestamp.substring(17, 19));
    }

    public int compareTo(TimeStamp other, String gra) {
        for (int i = 0; i < priorities.length; i++) {
            String p = priorities[i];
            if (other.map.get(p).compareTo(this.map.get(p)) != 0) {
                int a = toInteger(this.map.get(p));
                int b = toInteger(other.map.get(p));
                return a - b;
            }
            if (p.equals(gra)) {
                break;
            }
        }
        return 0;
    }

    private int toInteger(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 10 + Character.getNumericValue(s.charAt(i));
        }
        return res;
    }
}
