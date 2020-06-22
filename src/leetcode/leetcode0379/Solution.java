package leetcode0379;

public class Solution {

    public void test() {
//        PhoneDirectory pd = new PhoneDirectory(3);
//        System.out.println(pd.get());
//        System.out.println(pd.get());
//        System.out.println(pd.check(0));

        boolean[] used = new boolean[10];
        for (int i = 0; i < 6; i++) {
            used[i] = true;
        }

        int l = 0, r = 9;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (used[mid]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        System.out.println(l + ", " + r + ", " + used[l]);
    }
}

/*
["",
"get()",
"get()",
"check(0)",
"check(1)",
"check(2)",
"get",
"check(0)",
"check(1)",
"check(2)",
"release(2)",
"check(2)",
"get",
"check(2)"]

*/