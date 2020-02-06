package googleInterview.randomMaze;

public class Solution {

    public void test() {
        Maze maze = new Maze(21);
        char[][] board = maze.generate();
        maze.print();
    }
}
