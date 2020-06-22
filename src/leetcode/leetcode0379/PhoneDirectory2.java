package leetcode0379;

public class PhoneDirectory2 {
    int num = 1;
    int capacity;
    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory2(int maxNumbers) {
        capacity = maxNumbers;
        for (int i = 0; i< maxNumbers; i++) {
            num <<= 1;
            num++;
        }
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (num == 1) {
            return -1;
        }
        int cnt = num;
        int res = 0;
        while (cnt > 1) {
            cnt >>= 1;
            res += 1;
        }
        num >>= 1;
        return capacity - cnt;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return false;
    }

    /** Recycle or release a number. */
    public void release(int number) {

    }
}