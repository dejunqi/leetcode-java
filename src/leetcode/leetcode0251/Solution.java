package leetcode0251;

public class Solution {

    public void test() {
        int[][] arr = {{1}, {}};
        Vector2D vec = new Vector2D(arr);
        System.out.println(vec.hasNext());
        System.out.println(vec.next());
        System.out.println(vec.hasNext());
    }

}
