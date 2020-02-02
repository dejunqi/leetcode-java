package utils.practice;


import java.util.*;

/*
Greedy approach: start from the smallest sum container, add the largest value of the array , repeatly
[1, 2, 3, 4, 5]
[], // sum = 0
[], // sum = 0
[]  // sum = 0

[1, 2, 3, 4]
[5], // sum = 5
[], // sum = 0
[]  // sum = 0

[1, 2, 3, 4]
[5],
[4],
[]


[1, 2]
[5],
[4],
[3]


[1, 2]
[5],
[4],
[3, 2]

[]
[5],
[4, 1],
[3, 2]
*/
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int candidate = Integer.MAX_VALUE;
        int len = A.length;
        Arrays.sort(A);
        for (int i = A.length - 1; i > 0; i--) {
            if (A[i] - A[i - 1] > 1) {
                candidate = Math.min(A[i] - 1, candidate);
            }
        }

        if (candidate == Integer.MAX_VALUE) {
            return A[len - 1] + 1;
        }

        if (candidate <= 0) {
            return 1;
        }

        return candidate;
    }


}


