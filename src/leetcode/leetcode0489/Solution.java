package leetcode0489;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        int[] initDir = {0, 1};
        helper(robot, 0, 0, initDir, visited);
    }

    private void helper(Robot robot, int i, int j, int[] dir, Set<String> visited) {
        robot.clean();
        visited.add(i + "," + j);

        for (int k = 0; k < 4; k++) {
            int r = i + dir[0], c = j + dir[1];
            if (!visited.contains(r + "," + c) && robot.move()) {
                helper(robot, r, c, dir, visited);
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnLeft();
                robot.turnLeft();
            }
            robot.turnLeft();
            int tmp = dir[0];
            dir[0] = -dir[1];
            dir[1] = tmp;
        }
    }
}