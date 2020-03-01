package microsoftOA.planeSeatReservation;

import java.util.*;


/**
 * https://leetcode.com/discuss/interview-question/492652/
 *
 * We consider the get and put method for Set and Map to O(1) time (averagely)
 * The method takes O(N * 10) ~ O(N) time
 * O(N) space with the map and set to store the seats that has been reserved.
 */
public class Solution {
    public int seatReserve(int N, String str) {
        Map<Integer, Set<String>> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            map.put(i, new HashSet<>());
        }

        String[] strs = str.split("\\s+");
        String[][] allowedCases = {{"B", "C", "D", "E"},
                            {"D", "E", "F", "G"},
                            {"F", "G", "H", "J"}};

        for (String s : strs) {
            int num = Integer.parseInt(s.substring(0, s.length() - 1));
            String seat = s.substring(s.length() - 1);
            map.get(num).add(seat); // record the occupied seats for every row.
        }

        int res = 0;
        for (Integer row : map.keySet()) {
            Set<String> seats = map.get(row);
            for (String[] arrange : allowedCases) {
                // for the one row, if all 4 of the listed seats are empty, we can reserve them for one family
                if (!seats.contains(arrange[0]) && !seats.contains(arrange[1]) && !seats.contains(arrange[2]) && !seats.contains(arrange[3])) {
                    res += 1;
                    seats.addAll(Arrays.asList(arrange)); // reserve them
                }
            }
        }

        return res;
    }

    public void test() {
        int N = 2;
        String str = "1A 2F 1C";
        System.out.println(this.seatReserve(N, str));
    }
}
