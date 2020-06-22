package microsoftOA.dayOfWeek;

/*
Dyas of the week are represented as 3 letters strings ("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun").
Given a string S repreenting the day of the week and an integer K.
Returns the day of the week that is K days later

Example:

Input: S = "Wed", K = 2
output: Fri
* */
public class Solution {
    public String daysOfWeek(String s, int K) {
        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        int pos = 0;
        for (int i = 0; i < 7; i++) {
            if (days[i].equals(s)) {
                pos = i;
                break;
            }
        }
        K += pos;
        K %= 7;
        return days[K];
    }

    public void test() {
        System.out.println(daysOfWeek("Tue", 7));
    }
}
