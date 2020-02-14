package leetcode0681;

public class Solution {
    public String nextClosestTime(String time) {
        Clock clock = new Clock(time);
        String res = "";
        while (true) {
            clock.addMinite();
            String newtime = clock.getTime();
            if (clock.allCurrentDigitsReused(newtime)) {
                res = newtime;
                break;
            }
        }
        return res;
    }
    public void test() {
        System.out.println(nextClosestTime("19:34"));
    }
}
