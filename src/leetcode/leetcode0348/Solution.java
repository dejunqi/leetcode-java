package leetcode0348;

/**
 ["TicTacToe","move","move","move"]
 [[2],[0,1,1],[1,1,2],[1,0,1]]
 */
public class Solution {

    public void test() {
        TicTacToe obj = new TicTacToe(2);
        int r1 = obj.move(0, 1, 1);
        int r2 = obj.move(1, 1, 2);
        int r3 = obj.move(1, 0, 1);
    }
}
