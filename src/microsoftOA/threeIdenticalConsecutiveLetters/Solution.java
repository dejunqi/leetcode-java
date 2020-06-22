package microsoftOA.threeIdenticalConsecutiveLetters;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


/**
 https://leetcode.com/discuss/interview-question/398039/

 Given a string S of N lowercase English letters, returns a string with no instances of 3 identical consecutive letters,
 obtained from S by deleting the minimum possible number of letters.

 Examples:

 Input: S = "eedaaad"
 output : "eedaad"

 Input: s = "xxxtxxx"
 output: "xxtxx"
*/
public class Solution {

    public String mimiDeletion(String s) {
        int cnt = 0;
        int len = s.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
                cnt = 1;
            } else { // if (stack.peek() == c
                if (cnt < 2) {
                    cnt++;
                    stack.push(c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    public void test() {
        String s1 = "eedaaad"; // -> eedaad
        String s2 = "xxxtxxx"; // => xxtxx
        String s3 = "uuuuxaaaaxuuu"; // => uuxaaxuu
        System.out.println(mimiDeletion(s1));
        System.out.println(mimiDeletion(s2));
        System.out.println(mimiDeletion(s3));
    }
}
