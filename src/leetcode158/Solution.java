package leetcode158;
import java.util.*;

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    private Queue<Character> queue = new LinkedList<>();
    public int read(char[] buf, int n) {
        int time = n / 4;
        if (n % 4 > 0) {
            time += 1;
        }

        int ptr = 0;

        for (int i = 0; i < time; i++) {
            char[] tmp = new char[4];
            int num = read4(tmp);
            for (int j = 0; j < num; j++) {
                queue.offer(tmp[j]);
            }

            if (queue.isEmpty() || ptr == n) break;

            while (ptr < n && !queue.isEmpty()) {
                buf[ptr] = queue.poll();
                ptr += 1;
            }
        }

        return ptr;
    }
}