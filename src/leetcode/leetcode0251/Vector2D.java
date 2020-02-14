package leetcode0251;

public class Vector2D {

    private int row;
    private int col;
    int[][] vector;
    public Vector2D(int[][] v) {
        row = col = 0;
        vector = v;
        while (row < vector.length && col == vector[row].length) {
            row++;
            col = 0;
        }
    }

    public int next() {
        int res = vector[row][col];
        col++;
        while (row < vector.length && col == vector[row].length) {
            row++;
            col = 0;
        }
        return res;
    }

    public boolean hasNext() {
        return row <= vector.length - 1;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */