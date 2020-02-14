package leetcode0844;
import java.util.Stack;

public class Solution {
    public boolean backspaceCompare(String S, String T) {

        String s1 = convert(S);
        String s2 = convert(T);
        return s1.equals(s2);
    }

    private String convert(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public void test() {
        String s1 = "a##c";
        String s2 = "#a#c";
        System.out.println(backspaceCompare(s1, s2));
    }
}