package leetcode0731;

public class Solution {

    public void test() {
        MyCalendarTwo calendar = new MyCalendarTwo();
        int[][] intervals = {{10,20},{50,60},{10,40},{5,15},{5,10},{25,55}};
        for (int[] interval : intervals) {
            boolean res = calendar.book(interval[0], interval[1]);
            System.out.println(res);
        }
    }
}
