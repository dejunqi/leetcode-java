package leetcode0158;
import java.util.*;

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */

    private Queue<Character> queue = new LinkedList<>();

    public int read(char[] buf, int n) {
        int idx = 0;
        while (!queue.isEmpty() && idx < n) {
            buf[idx++] = queue.poll();
        }


        int time = (n - idx) / 4;
        if ( (n - idx) % 4 != 0) {
            time++;
        }

        for (int i = 0; i < time; i++) {
            char[] tmp = new char[4];
            int num = read4(tmp);
            for (int j = 0; j < num; j++) {
                if (idx < n) {
                    buf[idx++] = tmp[j];
                } else {
                    queue.offer(tmp[j]);
                }
            }
            if (num < 4) {
                break;
            }
        }

        return idx;
    }
}