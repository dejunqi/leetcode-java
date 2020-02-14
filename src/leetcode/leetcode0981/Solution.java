package leetcode0981;

public class Solution {

    public void test() {
        TimeMap timemap = new TimeMap();

        timemap.set("love", "high", 10);
        timemap.set("love", "low", 20);

        String val1 = timemap.get("love", 5);
        String val2 = timemap.get("love", 10);
        String val3 = timemap.get("love", 15);
        String val4 = timemap.get("love", 20);
        String val5 = timemap.get("love", 25);

        String[] vals = {val1, val2, val3, val4, val5};
        for (String v : vals) {
            if (v.equals("")) {
                System.out.println("NULL");
            } else {
                System.out.println(v);
            }
        }
    }

}
