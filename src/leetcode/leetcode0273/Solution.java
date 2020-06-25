package leetcode.leetcode0273;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private final String[] ONES = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    private final String[] TENS = {
            "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        int idx = 0;
        StringBuilder res = new StringBuilder();
        while (num > 0) {
            if (num % 1000 != 0) {
                res.insert(0, helper(num % 1000) + THOUSANDS[idx] + " ");
            }
            num /= 1000;
            idx += 1;
        }

        return res.toString().trim();
    }

    private String helper(int num) {
        if (num == 0) {
            return "";
        }
        if (num < 20) {
            return ONES[num] + " ";
        }
        if (num < 100) {
            return TENS[num / 10] + " " + helper(num % 10);
        }

        return helper(num / 100) + "Hundred " + helper(num % 100);
    }

    public void test() {
        int num = 1234567;
        System.out.println(numberToWords(num));
    }

}
