
import leetcode0384.Solution;


public class Main {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6};
        Solution obj = new Solution(nums);
        int[] res = obj.shuffle();
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
