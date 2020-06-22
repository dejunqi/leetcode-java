package leetcode.leetcode0157;

/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int times = n / 4;
        if (n % 4 > 0) {
            times++;
        }
        int ptr = 0;
        for (int i = 0; i < times; i++) {
            char[] tmp = new char[4];
            int num = read4(tmp);
            for (int j = 0; j < num; j++) {
                buf[ptr] = tmp[j];
                ptr++;
                if (ptr == n) {
                    break;
                }
            }

        }
        return ptr;
    }
}
