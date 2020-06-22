package microsoftOA.minSwapstoGroupRedBalls;

import java.util.ArrayList;
import java.util.List;

/**
 * There are N balls positioned in a row. Each of them is either red or white. In one move we can swap two adjacent balls. We want to arrange all
 * the red balls into a consistent segment. What is the minimum number of swaps needed ?
 *
 * Example:
 *
 * Input S = "WRRWWR"
 * output: 2
 * Explain
 * 1st "WRRWRW"
 * 2ND "WRRRWW"
 *
 *
 * Input: WWRWWWRWR
 * output: 4
 *
 * explain:
 *
 * 1st WWWRWWRWR
 * 2nd WWWWRWRWR
 * 3rd WWWWWRRWR
 * 4th WWWWWRRRW
 *
                    W W R W W W R W R

 The min swap to group red balls is the distance for the red balls to walk toward each other until they sit next to each other.
 */

public class Solution {

    public int solution(String s) {
        int redCnt = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'R') {
                redCnt++;
            }
        }
        int i = 0, j = len - 1;
        int res = 0;
        while (true) {
            while (i < j && s.charAt(i) != 'R') {
                i++;
            }
            while (i < j && s.charAt(j) != 'R') {
                j--;
            }
            if (i >= j) {
                break;
            }
            redCnt -= 2;
            res += (j - i - 1 - redCnt); // the distance between two red balls.
            i++;
            j--;
        }

        return res;
    }

    public void test() {
        String[] testcase = {
                "RRRWRR",
                "WWRWWWRWR",
                "WWW",
                "RW",
                "WRRWWR",
                "WRRRWWWRRWRWRWR"
        };
        List<Integer> res = new ArrayList<>();
        for (String s : testcase) {
            res.add(solution(s));
        }
        System.out.println(res);
    }
}
