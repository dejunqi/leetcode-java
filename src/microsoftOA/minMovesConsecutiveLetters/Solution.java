package microsoftOA.minMovesConsecutiveLetters;

/*
You are given a string S consisting of N letters 'a' and/or 'b'. In one move, You can swap on letter for the other.
(a, b for b, a)

Write a function that, given such a string S, returns the minimum number of moves required to obtain a string
containing instances of three identical consecutive letters.

Examples:
1. Given S = "baaaaa", the function should return 1. The string without 3 identical consecutive letter which
can be obtained in one move is "baabaa";

2. Input S = "baaabbaabbba",
output: 2
There are four valid strings obtainable in two movess
*/
public class Solution {
    public int numOfmove(String s) {
        // Use 2 array with length of 2
        // fist element of the array record the number of consecutive 'a'
        // 2dn element of the array record the number of occurence of 3 consecutive character
        int[] ca = {0, 0};
        int[] cb = {0, 0};
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'a') {
                ca[0] += 1; // increase number of consecutive identical 'a'
                cb[0] = 0; // also, reset cb[0] = 0, consecutive of b breaks.
                if (ca[0] == 3) { // if number of consecutive of 'a' reach to 3
                    ca[0] = 0; // reset it.
                    ca[1] += 1;
                }
            } else {
                cb[0] += 1;
                ca[0] = 0;
                if (cb[0] == 3) {
                    cb[0] = 0;
                    cb[1] += 1;
                }
            }
        }
        return ca[1] + cb[1];
    }

    public void test() {
        String S1 = "baaabbaabbba";
        String S2 = "baaaaa";
        String S3 = "baabab";
        int cnt = numOfmove(S1);
        System.out.println(cnt);
    }
}
